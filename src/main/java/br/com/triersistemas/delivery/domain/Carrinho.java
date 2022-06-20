package br.com.triersistemas.delivery.domain;

import br.com.triersistemas.delivery.enums.StatusCarrinhoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Carrinho {

    private UUID id;
    private List<Produto> produtos;
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
        }
        return this;
    }



}
