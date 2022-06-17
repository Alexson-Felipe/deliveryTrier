package br.com.triersistemas.delivery.model;

import br.com.triersistemas.delivery.enums.TipoProdutoEnum;
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
    @NotBlank
    private BigDecimal preco;

    @NotNull
    @NotBlank
    private TipoProdutoEnum tipo;
}
