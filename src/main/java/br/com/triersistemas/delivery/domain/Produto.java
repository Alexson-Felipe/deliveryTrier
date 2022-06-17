package br.com.triersistemas.delivery.domain;

import br.com.triersistemas.delivery.enums.TipoProdutoEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class Produto {

    private UUID id;
    private String nome;
    private BigDecimal preco = BigDecimal.ZERO;
    private TipoProdutoEnum tipo;

   public static List<Produto> produtosCadastrado;



    public Produto(String nome, BigDecimal preco, TipoProdutoEnum tipo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
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
