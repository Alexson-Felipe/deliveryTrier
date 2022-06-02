package br.com.triersistemas.delivery;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Carrinho {

    private List<Produto> produto;
    private Integer quantidade;
    private BigDecimal total;

    public Carrinho() {

    }

    public Carrinho(List<Produto> produto, Integer quantidade, BigDecimal total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
    }

    @Override
    public String toString() {

        //   return "Produto: " + produto.get(0).getNome() + "\nQuantidade: " + (quantidade = produto.size()) + "\nTotal: " + total;
        var df = new DecimalFormat("0.00");

        //produto.stream().map(p -> "\nProduto: " + p.getNome() + "\nPreço: " +  df.format(p.getPreco())  + "\nQuantidade: " + quantidade + "\nCategoria: " + p.getTipo()).forEach(System.out::println);
        return "";


    }
}
