package br.com.triersistemas.delivery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Scanner;

@AllArgsConstructor
@Getter
@ToString
public class Endereco {


    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    public static Endereco cadastraEndereco() {

        Scanner sc = new Scanner(System.in);
        System.out.println("****CADASTRAR ENDEREÇO****");
        System.out.print("Digite a rua: ");
        var rua = sc.nextLine();
        System.out.print("Digite o numero: ");
        var numero = sc.nextLine();
        System.out.print("Digite o bairro: ");
        var bairro = sc.nextLine();
        System.out.print("Digite o cidade: ");
        var cidade = sc.nextLine();

        return new Endereco(rua, numero, bairro, cidade);
    }

}
