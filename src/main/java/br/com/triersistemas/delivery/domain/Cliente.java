package br.com.triersistemas.delivery.domain;

import lombok.Getter;

import java.util.UUID;


@Getter
public class Cliente {

    private UUID id;
    private String nome;
    private String cpf;
    private String senha;

    private Carrinho carrinho;

    public Cliente() {
        carrinho = new Carrinho();
    }

    public Cliente(String nome, String cpf, String senha) {
        this();
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Cliente(String nome, String cpf, String senha, Carrinho carrinho) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.carrinho = carrinho;

    }

    public Cliente editar(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        return this;
    }

}
