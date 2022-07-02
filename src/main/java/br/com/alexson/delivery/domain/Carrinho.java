package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import br.com.alexson.delivery.enums.StatusCarrinhoEnum;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.RemoverProdutoCarrinhoModel;
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
    private Cliente cliente;
    private Integer quantProdutos;
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

    public Carrinho removerProduto(final UUID id, RemoverProdutoCarrinhoModel model) {
        if (StatusCarrinhoEnum.VAZIO.equals(this.status) || StatusCarrinhoEnum.AGUARDANDO_PAGAMENTO.equals(this.status)) {

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
        if (StatusCarrinhoEnum.AGUARDANDO_PAGAMENTO.equals(this.status)) {
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

