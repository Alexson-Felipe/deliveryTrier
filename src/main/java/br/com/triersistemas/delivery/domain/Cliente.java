package br.com.triersistemas.delivery.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
public class Cliente extends Pessoa {


    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }



}
