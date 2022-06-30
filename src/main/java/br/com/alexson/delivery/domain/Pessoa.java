package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.helper.Util;
import lombok.Getter;

import java.util.UUID;

//@Entity
@Getter
public abstract class Pessoa {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    private String cpf;
    //private String senha;

    public Pessoa() {
        this.id = UUID.randomUUID();
    }

    public Pessoa(String nome, String cpf) {
        this();
        this.nome = nome;
        this.cpf = Util.extractNumbers(cpf);;
        //this.senha = senha;
    }

    public Pessoa editar(String nome) {
        this.nome = nome;
       // this.senha = senha;
        return this;
    }

    public String getCpf() {
        if (cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }
}
