package br.com.triersistemas.delivery.domain;

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
    private List<Produto> produto;
    private BigDecimal total;


    public Carrinho() {
        this.id = UUID.randomUUID();
    }

    public Carrinho(List<Produto> produto) {
        this();
        this.produto = produto;
        this.total = BigDecimal.ZERO;
    }

    public Carrinho(List<Produto> produto, BigDecimal total) {
        this();
        this.produto = produto;
        this.total = total;
    }

    public Carrinho( BigDecimal total) {
        this.total = total;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal somaProdutos(List<Produto> listProdutos) {

        if (!Objects.isNull(listProdutos)) {

            for (int i = 0; i < produto.size(); i++) {
                total = total.add(produto.get(i).getPreco());
            }
        } else {
            total = BigDecimal.ZERO;

        }
        return total;
    }




    @Override
    public String toString() {
        var df = new DecimalFormat("0.00");

        var sB = new StringBuilder();
        for (int i = 0; i < produto.size(); i++) {
            sB.append("\nNome: ").append(produto.get(i).getNome());
            sB.append("\nNome: ").append(df.format(produto.get(i).getPreco()));
            sB.append("\nCategoria: ").append(produto.get(i).getTipo().getDescricao());
            sB.append("\n");
        }

        return sB.toString();


    }
}
