package br.com.triersistemas.delivery.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Getter
@Setter
@ToString
public class Cliente {

    private String nome;
    private String cpf;
    private String senha;
    private List<Produto> produto;
    private Carrinho carrinho;

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String senha) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Cliente(String nome, String cpf, String senha, List<Produto> produto, Carrinho carrinho) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.produto = produto;
        this.carrinho = carrinho;

    }



    public Cliente(String nome, String cpf, String senha, Carrinho carrinho) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.carrinho = carrinho;
    }

    public static Cliente cadastraCliente() {
        boolean controlador = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("__________________________");
        System.out.println("    CADASTRAR CLIENTE     ");
        System.out.println("͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞");
        System.out.print("Digite seu nome: ");
        var nome = sc.nextLine();
        System.out.print("Digite CPF: ");
        var cpf = sc.nextLine();

        System.out.print("Digite uma Senha: ");
        var senha = sc.nextLine();

        System.out.println();
        Carrinho carrinhoCliente = new Carrinho(BigDecimal.ZERO);

        System.out.println("\n****CLIENTE CADASTRADO****\n");

        return new Cliente(nome, cpf, senha, carrinhoCliente);
    }


}
