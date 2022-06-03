package br.com.triersistemas.delivery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {

        criaUsuarioAutomatico();
        loginOuCriarConta();

    }

    public static void loginOuCriarConta() {

        boolean opcao = true;

        do {

            System.out.println("__________________________");
            System.out.println("      MERCADO TRIER       ");
            System.out.println("͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞");
            System.out.print("1 >> LOGIN\n2 >> CRIAR CONTA\n::::: ");

            try {
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
            } catch (InputMismatchException e) {
                opcao = false;
                System.err.println("\n!!!!ERRO PROGRAMA FINALIZADO!!!!\n");
            }


        } while (opcao);


    }

    public static void login() {

        System.out.print("\nDigite o nome ou CPF: ");
        String nomeOuCpf = sc.next();
        System.out.print("Digite a senha: ");
        String senha = sc.next();

        for (int i = 0; i < clientes.size(); i++) {
            if ((clientes.get(i).getNome().equals(nomeOuCpf) || clientes.get(i).getCpf().equals(nomeOuCpf)) && clientes.get(i).getSenha().equals(senha)) {
                menuPrincipal(i, clientes.get(i).getNome(), clientes.get(i).getCpf());
            } else {
                System.out.println("\n!!!!SENHA INVÁLIDA!!!!");
            }

        }


    }

    public static void menuPrincipal(int posicao, String nome, String cpf) {
        int digito = 0;

        do {

            informacao(posicao, nome);
            System.out.print("1 >> Comprar\n2 >> Carrinho\n3 << Voltar\n::::: ");
            try {
                digito = sc.nextInt();

                if (digito == 1) {
                    comprarProduto(posicao, nome, cpf);
                } else if (digito == 2) {
                    carrinhoDeCompras(posicao, cpf);
                } else if (digito < 1 || digito > 4) {
                    System.out.println("\n!!!!OPÇÃO INVALIDA!!!!");
                }

            } catch (InputMismatchException e) {
                digito = 3;
            }

        } while (digito != 3);

    }

    public static void carrinhoDeCompras(int posicao, String cpf) {
        boolean verificador = true;

        for (Cliente cliente : clientes) {
            if (cliente.getCarrinho().getProdutoListagem().size() > 0 && cliente.getCpf().equals(cpf)) {
                System.out.println(cliente.getCarrinho());
                verificador = false;

            } else if (verificador && cliente.getCarrinho().getProdutoListagem().size() == 0) {
                System.out.println("\n!!!!CARRINHO VAZIO!!!!");
                verificador = false;
            }
        }


    }

    public static void listarProdutos() {
        new Produto();
        int id = 0;

        System.out.println();
        for (Produto produto : Produto.produtosCadastrado) {

            System.out.println("Id:[" + (id++) + "] " + produto);
        }

    }

    public static void comprarProduto(int posicao, String nome, String cpf) {
        int digito = 0;

        do {

            informacao(posicao, nome);
            System.out.print("1 >> Adicionar Produto\n2 >> Pagar\n3 << Voltar\n::::: ");
            digito = sc.nextInt();

            if (digito == 1) {
                listarProdutos();
                adicionarProdutos(posicao);
            } else if (digito == 2) {
                pagar(posicao, nome);
            } else if (digito < 1 || digito > 3) {
                System.out.println("\n!!!!OPÇÃO INVALIDA!!!!");
            }

        } while (digito != 3);
    }

    public static void adicionarProdutos(int posicao) {

        List<Produto> produtosAdd = new ArrayList<>();

        System.out.print("\nForma de adicionar: 1,2,9\n::::: ");

        try {

            String[] adicionar = sc.next().split(",");

            for (int i = 0; i < adicionar.length; i++) {

                for (Produto pro : Produto.produtosCadastrado) {

                    if (pro.getCodigo() == Integer.parseInt(adicionar[i])) {

                        produtosAdd.add(pro);

                    }
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("!!!!DIGITE NÚMEROS!!!!");
        }

        clientes.get(posicao).getCarrinho().setProdutoListagem(produtosAdd);
        clientes.get(posicao).getCarrinho().somaProdutos(clientes.get(posicao).getCarrinho().getProdutoListagem());

    }

    public static void informacao(int posicao, String nome) {
        var espaco = new StringBuilder();


        for (int i = 0; i < 13 - nome.length(); i++) {
            espaco.append(" ");

        }

        System.out.print("\n__________________________");
        System.out.print("\nUSUÁRIO       @TOTAL GASTO");
        System.out.println("\n@" + nome + espaco.toString() + "R$" + clientes.get(posicao).getCarrinho().getTotal());
        System.out.println("͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞͞");


    }

    public static void pagar(int posicao, String nome) {
        int digito = 0;
        do {
            informacao(posicao, nome);
            System.out.print("1 - Crédito\n2 - Debito\n3 - Dinheiro\n4 < Voltar\n::::: ");
            try {
                digito = sc.nextInt();

                if (digito == 1) {
                    clientes.get(posicao).getCarrinho().setProdutoListagem(null);
                    clientes.get(posicao).getCarrinho().somaProdutos(clientes.get(posicao).getCarrinho().getProdutoListagem());
                } else if (digito == 2) {
                    clientes.get(posicao).getCarrinho().setProdutoListagem(null);
                    clientes.get(posicao).getCarrinho().somaProdutos(clientes.get(posicao).getCarrinho().getProdutoListagem());
                } else if (digito == 3) {
                    clientes.get(posicao).getCarrinho().setProdutoListagem(null);
                    clientes.get(posicao).getCarrinho().somaProdutos(clientes.get(posicao).getCarrinho().getProdutoListagem());
                } else if (digito < 1 || digito > 4) {
                    System.out.println("\n!!!!OPÇÃO INVALIDA!!!!");
                }

            } catch (InputMismatchException e) {
                digito = 4;
            }


        } while (digito != 4);

    }

    public static void criaUsuarioAutomatico() {

        new Produto();

        Carrinho carrinho = new Carrinho(BigDecimal.ZERO);

        Cliente cliente = new Cliente("admin", "1234", "admin", carrinho);
        cliente.getCarrinho().somaProdutos(cliente.getCarrinho().getProdutoListagem());
        clientes.add(cliente);


    }


}
