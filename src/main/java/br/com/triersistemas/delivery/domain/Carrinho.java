package br.com.triersistemas.delivery.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Carrinho {

    private List<Produto> produtoListagem = new ArrayList<>();

    private BigDecimal total;

    public Carrinho() {

    }

    public Carrinho(List<Produto> produto) {
        this.produtoListagem = produto;
    }

    public Carrinho(List<Produto> produto, BigDecimal total) {
        this.produtoListagem = produto;
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

            for (int i = 0; i < listProdutos.size(); i++) {
                total = total.add(produtoListagem.get(i).getPreco());
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
        for (int i = 0; i < produtoListagem.size(); i++) {
            sB.append("\nNome: ").append(produtoListagem.get(i).getNome());
            sB.append("\nNome: ").append(df.format(produtoListagem.get(i).getPreco()));
            sB.append("\nQuantidade: ").append(produtoListagem.get(i).getQuantidadeProdutos());
            sB.append("\nCategoria: ").append(produtoListagem.get(i).getTipo().getDescricao());
            sB.append("\n");
        }

        return sB.toString();


    }
}
