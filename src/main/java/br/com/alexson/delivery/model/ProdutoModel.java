package br.com.alexson.delivery.model;

import br.com.alexson.delivery.enums.TipoProdutoEnum;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class ProdutoModel {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private TipoProdutoEnum tipo;
}
