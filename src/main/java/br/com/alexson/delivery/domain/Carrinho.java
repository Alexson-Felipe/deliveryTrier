package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import br.com.alexson.delivery.enums.StatusCarrinhoEnum;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.ClienteModel;
import br.com.alexson.delivery.model.ItemCarrinhoModel;
import br.com.alexson.delivery.model.ProdutoModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//@Entity
//@Table(name = "carrinho")
@Getter
@NoArgsConstructor
public class Carrinho {
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
   // @ManyToOne
   // @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
   // @Enumerated(EnumType.STRING)
    private StatusCarrinhoEnum status;
    ///@ManyToMany
   // @JoinTable(
     //       name = "pedido_produto",
      //      joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
       //     inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id"))
    private List<ItemCarrinho> itens;

    private BigDecimal total;

    public Carrinho(final ClienteModel clienteModel) {
        itens = new ArrayList<>();
        //this.cliente = clienteModel;
        this.status = StatusCarrinhoEnum.VAZIO;
        this.total = BigDecimal.ZERO;
    }

    public Carrinho adicionarProduto(final ProdutoModel produto) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO.equals(this.status)) {

            for (ItemCarrinho itemC : itens) {

                if (itemC.getProduto().getId().equals(produto.getId())) {
                    itemC.adicionarQuantProdutos();
                    this.total = this.itens.stream()
                            .filter(p -> p.getProduto().getId().equals(produto.getId()))
                            .map(ic -> ic.getProduto().getPreco())
                            .reduce(this.total, BigDecimal::add);
                    this.status = StatusCarrinhoEnum.AGUARDANDO;
                    return this;
                }
            }

            var itemCarrinho = new ItemCarrinho(1, produto);
            itens.add(itemCarrinho);
            this.total = this.itens.stream()
                    .filter(p -> p.getProduto().getId().equals(produto.getId()))
                    .map(ic -> ic.getProduto().getPreco())
                    .reduce(this.total, BigDecimal::add);
            this.status = StatusCarrinhoEnum.AGUARDANDO;


        }

        return this;
    }

    public Carrinho removerProduto(final UUID id, ItemCarrinhoModel model) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO.equals(this.status)) {

            var itemCa = itens.stream()
                    .filter(itemCarrinho -> itemCarrinho.getId().equals(model.getIdItemCarrinho()))
                    .findFirst()
                    .orElseThrow(NaoExisteException::new);

            itemCa.removeQuantProdutos();
            this.total = this.total.subtract(itemCa.getProduto().getPreco());

            if (itemCa.getQtd() == 0) {
                this.itens.remove(itemCa);

            }

            if (total.compareTo(BigDecimal.ZERO) <= 0) {
                this.status = StatusCarrinhoEnum.VAZIO;
                this.total = BigDecimal.ZERO;
            }
        }
        return this;
    }

    public Carrinho pagar(final UUID id, final FormaPagamentoEnum formaPagamentoEnum) {
        if (StatusCarrinhoEnum.AGUARDANDO.equals(this.status)) {
            var quantidade = this.itens.stream()
                    .map(ItemCarrinho::getQtd).findFirst().orElse(0);

            this.cliente.adicionarPontos(formaPagamentoEnum, quantidade);
            this.status = StatusCarrinhoEnum.PAGO;

        }

        return this;

    }
}