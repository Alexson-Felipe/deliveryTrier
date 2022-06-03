package br.com.triersistemas.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
public class Produto {

    private Integer codigo;
    private String nome;
    private BigDecimal preco = BigDecimal.ZERO;
    private Integer quantidadeProdutos;
    private TipoProdutoEnum tipo;

   public static List<Produto> produtosCadastrado;

    public Produto(){
        produtosCadastrado =  Arrays.asList(
                new Produto(0,"Shampoo Clear 400ml", BigDecimal.valueOf(20.90), 1, TipoProdutoEnum.BELEZA_PERFUMARIA),
                new Produto(1,"Shampoo Seda 325ml", BigDecimal.valueOf(8.89), 1, TipoProdutoEnum.BELEZA_PERFUMARIA),
                new Produto(2,"Condicionador Seda 325ml", BigDecimal.valueOf(6.95), 1, TipoProdutoEnum.BELEZA_PERFUMARIA),
                new Produto(3,"Ração Three Dogs 10KG", BigDecimal.valueOf(117.99), 1, TipoProdutoEnum.MERCEARIA),
                new Produto(4,"Ração Whiskas 10,5KG", BigDecimal.valueOf(152.99), 1, TipoProdutoEnum.MERCEARIA),
                new Produto(5,"Arroz 1kg", BigDecimal.valueOf(5.99), 1, TipoProdutoEnum.MERCEARIA),
                new Produto(6,"Arroz 5kg", BigDecimal.valueOf(20.90), 1, TipoProdutoEnum.MERCEARIA),
                new Produto(7,"Feijão 1kg", BigDecimal.valueOf(9.89), 1, TipoProdutoEnum.MERCEARIA),
                new Produto(8,"Desodorante Rexona 150ml", BigDecimal.valueOf(17.95), 1, TipoProdutoEnum.HIGIENE),
                new Produto(9,"Fralda Xg Pampers", BigDecimal.valueOf(74.61), 1, TipoProdutoEnum.HIGIENE),
                new Produto(10,"Escova Dental", BigDecimal.valueOf(5.79), 1, TipoProdutoEnum.HIGIENE)
        );

    }

    public Produto(Integer codigo, String nome, BigDecimal preco, Integer quantidadeProdutos, TipoProdutoEnum tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeProdutos = quantidadeProdutos;
        this.tipo = tipo;
    }



    @Override
    public String toString() {
        var sB = new StringBuilder();
        var df = new DecimalFormat("0.00");
        sB.append("Nome: ").append(nome);
        sB.append(" Preço: ").append(df.format(preco));
        sB.append(" Tipo: ").append(tipo.getDescricao());
        return sB.toString();
    }
}
