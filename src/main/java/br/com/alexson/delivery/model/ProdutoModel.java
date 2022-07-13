package br.com.alexson.delivery.model;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.enums.TipoProdutoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@NoArgsConstructor
@Getter
public class ProdutoModel {

    private UUID id;

    private String nome;
    private BigDecimal preco;

    private TipoProdutoEnum tipo;

    public ProdutoModel(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.tipo = produto.getTipo();
    }
}
