package br.com.triersistemas.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Endereco enderecoTest = new Endereco("Rua Teste", "sn", "Centro", "Cidade Teste");
        clientes.add(new Cliente("teste", "123456789", "teste", enderecoTest));

        loginOuCriarConta();


    }

    public static void loginOuCriarConta() {

        System.out.println("********************");
        boolean opcao = true;

        System.out.print("1 - LOGIN\n2 - CRIAR CONTA\n::::: ");
        var opcaoDigitada = sc.nextInt();

        do {

            switch (opcaoDigitada) {
                case 1:
                    login();
                    break;
                case 2:
                    clientes.add(Cliente.cadastraCliente());
                    break;
                default:
                    opcao = true;

            }

        } while (opcao == false);


    }

    public static void login() {

        System.out.print("\nDigite o nome ou CPF: ");
        String nomeOuCpf = sc.next();
        System.out.print("Digite a senha: ");
        String senha = sc.next();

        for (Cliente cl: clientes) {
            if (cl.getNome().equals(nomeOuCpf) || cl.getCpf().equals(nomeOuCpf)){
                
            }

        }


    }


}
