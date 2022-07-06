package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.TipoProdutoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;


@Getter
public class Produto {

    private UUID id;
    private String nome;
    private BigDecimal preco;
    private Integer quantProdutos;
    private TipoProdutoEnum tipo;

    public static List<Produto> produtosCadastrado;

    public Produto(){

    }
    public Produto(String nome, BigDecimal preco, TipoProdutoEnum tipo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.quantProdutos = 1;
    }

    public Produto editar(String nome, BigDecimal preco, TipoProdutoEnum tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        return this;
    }

    public void ajustarQuantidade(){
        quantProdutos++;
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
