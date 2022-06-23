package br.com.alexson.delivery.domain;

import java.util.UUID;

public class Endereco {

    private UUID id;
    private String numero;
    private String rua;
    private String cidade;
    private String estado;

    public Endereco(String numero, String rua, String cidade, String estado) {
        this.id = UUID.randomUUID();
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
    }

}
