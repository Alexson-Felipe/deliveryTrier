package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.TipoProdutoEnum;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "tipo")
    private TipoProdutoEnum tipo;

    //public static List<Produto> produtosCadastrado;

    public Produto(){

    }
    public Produto(String nome, BigDecimal preco, TipoProdutoEnum tipo) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    public Produto editar(String nome, BigDecimal preco, TipoProdutoEnum tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        return this;
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
