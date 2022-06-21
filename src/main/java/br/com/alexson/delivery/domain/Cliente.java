package br.com.alexson.delivery.domain;

import lombok.Getter;


@Getter
public class Cliente extends Pessoa {


    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
    }



}
