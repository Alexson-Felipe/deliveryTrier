package br.com.triersistemas.delivery.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Pessoa {

    private UUID id;
    private String nome;
    private String cpf;
    private String senha;

    public Pessoa(){
        this.id = UUID.randomUUID();
    }
    public Pessoa(String nome, String cpf, String senha) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa editar(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        return this;
    }
}
