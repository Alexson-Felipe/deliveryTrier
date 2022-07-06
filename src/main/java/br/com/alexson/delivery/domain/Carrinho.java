package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import br.com.alexson.delivery.enums.StatusCarrinhoEnum;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.RemoverProdutoCarrinhoModel;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Getter
public class Carrinho {

    private UUID id;
    private List<Produto> produtos;
    private Cliente cliente;
    private StatusCarrinhoEnum status;
    private List<ItemCarrinho> itens;

    private BigDecimal total;

    public Carrinho(final Cliente cliente) {
        this.id = UUID.randomUUID();
        itens = new ArrayList<>();
        this.cliente = cliente;
        this.status = StatusCarrinhoEnum.VAZIO;
        this.total = BigDecimal.ZERO;
    }

    public Carrinho adicionarProduto(final Produto produto) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO.equals(this.status)) {

            for (ItemCarrinho itemC : itens) {

                if (itemC.getProduto().getId().equals(produto.getId())) {
                    itemC.adicionarQuantProdutos();
                    this.total = this.itens.stream()
                            .filter(p -> p.getId().equals(produto.getId()))
                            .map(ic -> ic.getProduto().getPreco())
                            .reduce(this.total, BigDecimal::add);
                    this.status = StatusCarrinhoEnum.AGUARDANDO;
                    return this;
                }
            }

            var itemCarrinho = new ItemCarrinho(1, produto);
            itens.add(itemCarrinho);
            this.total = this.itens.stream()
                    .filter(p -> p.getId().equals(produto.getId()))
                    .map(ic -> ic.getProduto().getPreco())
                    .reduce(this.total, BigDecimal::add);
            this.status = StatusCarrinhoEnum.AGUARDANDO;


        }

        return this;
    }

    public Carrinho removerProduto(final UUID id, RemoverProdutoCarrinhoModel model) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO.equals(this.status)) {

            var prod = produtos.stream().filter(p -> p.getId().equals(model.getIdProduto()))
                    .findFirst().orElseThrow(NaoExisteException::new);

            var total = this.produtos.stream().map(Produto::getPreco).reduce(this.total, BigDecimal::subtract);

            this.produtos.remove(prod);

            this.total = this.produtos.stream()
                    .map(Produto::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            if (total.compareTo(BigDecimal.ZERO) == 0) {
                this.status = StatusCarrinhoEnum.VAZIO;
            }
        }
        return this;
    }

    public Carrinho pagar(final UUID id, final FormaPagamentoEnum formaPagamentoEnum) {
        if (StatusCarrinhoEnum.AGUARDANDO.equals(this.status)) {
            Integer quantidade = this.produtos.size();

            /*
            if (cupom != null) {
                this.total = total.multiply(cupom.getValorDesconto()).subtract(total);
            } else {
                this.total = BigDecimal.ZERO;
            }
             */

            this.cliente.adicionarPontos(formaPagamentoEnum, quantidade);
            this.status = StatusCarrinhoEnum.PAGO;

        }

        return this;

    }
}