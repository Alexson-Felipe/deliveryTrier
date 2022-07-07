package br.com.alexson.delivery.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ItemCarrinho {

    private UUID id;
    private Integer qtd;
    private Produto produto;

    private BigDecimal valorTotal;

    public ItemCarrinho(Integer qtd, Produto produto) {
        this.id = UUID.randomUUID();
        this.qtd = qtd;
        this.produto = produto;
        this.valorTotal = this.produto.getPreco().multiply(BigDecimal.valueOf(qtd));
    }

    public void adicionarQuantProdutos() {
        this.qtd++;
    }

    public void removeQuantProdutos() {
        this.qtd--;
    }

}
