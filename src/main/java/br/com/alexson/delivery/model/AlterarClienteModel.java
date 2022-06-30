package br.com.alexson.delivery.model;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class AlterarClienteModel {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    private String cpf;


}
