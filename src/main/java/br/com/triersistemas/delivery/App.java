package br.com.triersistemas.delivery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    static Scanner sc = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();
    static List<Carrinho> carrinhos = new ArrayList<>();
    static List<Produto> listaProdutos = new ArrayList<>();

    public static void main(String[] args) {
        Endereco enderecoTest = new Endereco("Rua admin", "sn", "centro", "Cidade Teste");
        new Produto();
        listaProdutos.add(Produto.produtosCadastrado.get(0));
        listaProdutos.add(Produto.produtosCadastrado.get(3));


        Carrinho carrinho = new Carrinho(listaProdutos, 0, BigDecimal.valueOf(0.00));
        clientes.add(new Cliente("admin", "1234", "admin", enderecoTest, carrinho));

        for (Produto p : listaProdutos) {
            System.out.println(p);
        }

        loginOuCriarConta();


    }

    public static void loginOuCriarConta() {

        boolean opcao = true;

        do {
            System.out.println("__________________________");
            System.out.println("      DELIVERY TRIER      ");
            System.out.println("͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞");
            System.out.print("1 - LOGIN\n2 - CRIAR CONTA\n::::: ");
            var opcaoDigitada = sc.nextInt();

            switch (opcaoDigitada) {
                case 1:
                    login();
                    break;
                case 2:
                    clientes.add(Cliente.cadastraCliente());
                    break;

                default:
                    System.out.println("\n!!!!OPÇÃO INVALIDA!!!!\n");
                    opcao = true;

            }

        } while (opcao);


    }

    public static void login() {

        System.out.print("\nDigite o nome ou CPF: ");
        String nomeOuCpf = sc.next();
        System.out.print("Digite a senha: ");
        String senha = sc.next();

        for (Cliente cl : clientes) {

        }

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nomeOuCpf) || clientes.get(i).getCpf().equals(nomeOuCpf)) {
                menuPrincipal(clientes.get(i).getNome(), clientes.get(i).getCarrinho().getTotal(), clientes.get(i).getCpf());
            }

        }


    }

    public static void menuPrincipal(String nome, BigDecimal total, String cpf) {
        int digito = 0;
        do {

            System.out.print("\n__________________________");
            System.out.print("\nUSUÁRIO       @TOTAL GASTO");
            System.out.println("\n@" + nome + "        R$" + total);
            System.out.println("͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞");

            System.out.print("1 - Comprar\n2 - Carrinho\n3 - Listar Produtos\n4 - < Voltar\n::::: ");
            digito = sc.nextInt();

            if (digito == 1) {

            } else if (digito == 2) {
                carrinhoDeCompras(cpf);
            } else if (digito == 3) {
                listarProdutos();
            } else if (digito < 1 || digito > 4) {
                System.out.println("\n!!!!OPÇÃO INVALIDA!!!!");
            }

        } while (digito != 4);

    }

    public static void carrinhoDeCompras(String cpf) {

        for (Cliente cliente : clientes) {
            if (cliente.getCarrinho().getProduto() == null) {
                System.out.println("\n!!!!CARRINHO VAZIO!!!!");
            } else {
                System.out.println(cliente.getCarrinho());
            }
        }


    }

    public static void listarProdutos() {

        for (Produto produto : Produto.produtos) {
            System.out.println(produto);
        }

    }


}
