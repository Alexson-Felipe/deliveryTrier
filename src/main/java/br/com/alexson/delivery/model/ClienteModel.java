package br.com.alexson.delivery.model;

import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class ClienteModel {

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    private String cpf;



}
