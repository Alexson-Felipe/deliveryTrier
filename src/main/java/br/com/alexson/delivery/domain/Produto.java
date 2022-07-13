package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.TipoProdutoEnum;
import br.com.alexson.delivery.model.ProdutoModel;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;
@NoArgsConstructor
@Getter
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private TipoProdutoEnum tipo;

    public Produto(String nome, BigDecimal preco, TipoProdutoEnum tipo) {
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

    public Produto(ProdutoModel model){
        this.nome = model.getNome();
        this.preco = model.getPreco();
        this.tipo = model.getTipo();
    }

}
