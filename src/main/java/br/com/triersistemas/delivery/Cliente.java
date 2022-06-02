package br.com.triersistemas.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Scanner;


@Getter
@ToString
public class Cliente {


    private String nome;
    private String cpf;
    private String senha;
    private Endereco endereco;
    private Carrinho carrinho;


    public Cliente(String nome, String cpf, String senha, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente(String nome, String cpf, String senha, Endereco endereco, Carrinho carrinho) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.carrinho = carrinho;
    }

    public static Cliente cadastraCliente(){
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
        Carrinho carrinhoCliente = new Carrinho(null, 0, BigDecimal.valueOf(0.00));


        Endereco end = Endereco.cadastraEndereco();

        System.out.println("\n****CLIENTE CADASTRADO****\n");
        return new Cliente(nome, cpf, senha, end, carrinhoCliente);
    }

}
