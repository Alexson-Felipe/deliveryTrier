package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.helper.Util;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

//@Entity
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;


    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = Util.extractNumbers(cpf);;
        //this.senha = senha;
    }

    public Pessoa editar(final String nome, final String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        return this;
    }

    public String getCpf() {
        if (cpf.length() == 11) {
            return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }
}
