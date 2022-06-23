package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import br.com.alexson.delivery.enums.StatusCarrinhoEnum;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Carrinho {

    private UUID id;
    private List<Produto> produtos;
    private List<Cupom> cupons;
    private Cliente cliente;
    private StatusCarrinhoEnum status;
    private BigDecimal total;

    public Carrinho(final Cliente cliente) {
        this.id = UUID.randomUUID();
        produtos = new ArrayList<>();
        this.cliente = cliente;
        this.status = StatusCarrinhoEnum.VAZIO;
        this.total = BigDecimal.ZERO;
    }

    public Carrinho adicionarProduto(final List<Produto> produtos) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO_PAGAMENTO.equals(this.status)) {
            this.produtos.addAll(produtos);
            this.total = this.produtos.stream()
                    .map(Produto::getPreco)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            this.status = StatusCarrinhoEnum.AGUARDANDO_PAGAMENTO;
        }

        return this;
    }

    public Carrinho removerProduto(final Carrinho carrinho) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO_PAGAMENTO.equals(this.status)) {
            this.produtos.remove(carrinho);
            this.total = this.produtos.stream()
                    .map(Produto::getPreco)
                    .reduce(this.total, BigDecimal::subtract);

            if(this.total.equals(0)){
                this.status = StatusCarrinhoEnum.VAZIO;
            }
        }
        return this;
    }

    public Carrinho pagar(final UUID id, final UUID idCupom, FormaPagamentoEnum formaPagamentoEnum) {
        if (StatusCarrinhoEnum.AGUARDANDO_PAGAMENTO.equals(this.status)) {
            Integer quantidade = this.produtos.size();

            var cuponExiste = cupons.stream()
                    .filter(c -> c.getId().equals(idCupom))
                    .findFirst().orElseThrow(NaoExisteException::new);


            this.cliente.adicionarPontos(formaPagamentoEnum, quantidade);

            if (cuponExiste.getId().equals(idCupom)){
                this.total = total.multiply(cuponExiste.getValorDesconto()).subtract(total);
                cupons.remove(cuponExiste);
            }else{
                this.total = BigDecimal.ZERO;
            }

            this.status = StatusCarrinhoEnum.PAGO;
        }
        return this;
    }



}
