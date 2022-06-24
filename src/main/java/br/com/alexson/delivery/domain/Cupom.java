package br.com.alexson.delivery.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Cupom {

    private UUID id;
    private String nome;
    private BigDecimal valorEmPontos;
    private BigDecimal valorDesconto;

    public Cupom(){

    }

    public Cupom(String nome,BigDecimal valorEmPontos, BigDecimal valorDesconto) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.valorEmPontos = valorEmPontos;
        this.valorDesconto = valorDesconto;
    }


}
