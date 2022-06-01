package br.com.triersistemas.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.SQLOutput;
import java.util.Scanner;

@AllArgsConstructor
@Getter
@ToString
public class Cliente {


    private String nome;
    private String cpf;
    private String senha;
    private Endereco endereco;


    public static Cliente cadastraCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("****CADASTRAR CLIENTE****");
        System.out.print("Digite seu nome: ");
        var nome = sc.nextLine();
        System.out.print("Digite CPF: ");
        var cpf = sc.nextLine();
        System.out.print("Digite uma Senha: ");
        var senha = sc.nextLine();
        System.out.println();

        Endereco end = Endereco.cadastraEndereco();

        return new Cliente(nome, cpf, senha, end);
    }

}
