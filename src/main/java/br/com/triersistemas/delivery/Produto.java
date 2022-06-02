package br.com.triersistemas.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
public class Produto {

    private String nome;
    private BigDecimal preco;
    private Integer qtdEstoque;
    private TipoProdutoEnum tipo;

   public static List<Produto> produtosCadastrado;


    public Produto(){
        produtosCadastrado =  Arrays.asList(
                new Produto("Shampoo Clear 400ml", BigDecimal.valueOf(20.90), 10, TipoProdutoEnum.BELEZA_PERFUMARIA),
                new Produto("Shampoo Seda 325ml", BigDecimal.valueOf(8.89), 10, TipoProdutoEnum.BELEZA_PERFUMARIA),
                new Produto("Condicionador Seda 325ml", BigDecimal.valueOf(6.95), 10, TipoProdutoEnum.BELEZA_PERFUMARIA),
                new Produto("Ração Three Dogs 10KG", BigDecimal.valueOf(117.99), 5, TipoProdutoEnum.MERCEARIA),
                new Produto("Ração Whiskas 10,5KG", BigDecimal.valueOf(152.99), 8, TipoProdutoEnum.MERCEARIA),
                new Produto("Arroz 1kg", BigDecimal.valueOf(5.99), 15, TipoProdutoEnum.MERCEARIA),
                new Produto("Arroz 5kg", BigDecimal.valueOf(20.90), 15, TipoProdutoEnum.MERCEARIA),
                new Produto("Feijão 1kg", BigDecimal.valueOf(9.89), 7, TipoProdutoEnum.MERCEARIA),
                new Produto("Desodorante Rexona 150ml", BigDecimal.valueOf(17.95), 10, TipoProdutoEnum.HIGIENE),
                new Produto("Fralda Xg Pampers", BigDecimal.valueOf(74.61), 10, TipoProdutoEnum.HIGIENE),
                new Produto("Escova Dental", BigDecimal.valueOf(5.79), 10, TipoProdutoEnum.HIGIENE)
        );

    }

    public static final List<Produto> produtos = List.of(
            new Produto("Shampoo Clear 400ml", BigDecimal.valueOf(20.90), 10, TipoProdutoEnum.BELEZA_PERFUMARIA),
            new Produto("Shampoo Seda 325ml", BigDecimal.valueOf(8.89), 10, TipoProdutoEnum.BELEZA_PERFUMARIA),
            new Produto("Condicionador Seda 325ml", BigDecimal.valueOf(6.95), 10, TipoProdutoEnum.BELEZA_PERFUMARIA),
            new Produto("Ração Three Dogs 10KG", BigDecimal.valueOf(117.99), 5, TipoProdutoEnum.MERCEARIA),
            new Produto("Ração Whiskas 10,5KG", BigDecimal.valueOf(152.99), 8, TipoProdutoEnum.MERCEARIA),
            new Produto("Arroz 1kg", BigDecimal.valueOf(5.99), 15, TipoProdutoEnum.MERCEARIA),
            new Produto("Arroz 5kg", BigDecimal.valueOf(20.90), 15, TipoProdutoEnum.MERCEARIA),
            new Produto("Feijão 1kg", BigDecimal.valueOf(9.89), 7, TipoProdutoEnum.MERCEARIA),
            new Produto("Desodorante Rexona 150ml", BigDecimal.valueOf(17.95), 10, TipoProdutoEnum.HIGIENE),
            new Produto("Fralda Xg Pampers", BigDecimal.valueOf(74.61), 10, TipoProdutoEnum.HIGIENE),
            new Produto("Escova Dental", BigDecimal.valueOf(5.79), 10, TipoProdutoEnum.HIGIENE)
    );

    public Produto(String nome, BigDecimal preco, Integer qtdEstoque, TipoProdutoEnum tipo) {
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        var df = new DecimalFormat("0.00");
        return "Nome: " + nome + " Preço: R$" + df.format(preco) + " Quantidade em Estoque: " + qtdEstoque + " Tipo: " + tipo;
    }
}
