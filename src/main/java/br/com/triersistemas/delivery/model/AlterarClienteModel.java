package br.com.triersistemas.delivery.model;

import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class AlterarClienteModel {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String senha;


}