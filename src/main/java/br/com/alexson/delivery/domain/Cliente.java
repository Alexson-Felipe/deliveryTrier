package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import lombok.Getter;


@Getter
public class Cliente extends Pessoa {

    private Integer pontos;

    public Cliente() {
        super();
        this.pontos = 0;
    }

    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.pontos = 0;
    }

    protected void adicionarPontos(FormaPagamentoEnum formaPagamentoEnum, Integer quantidade) {
        if (FormaPagamentoEnum.CREDITO.equals(formaPagamentoEnum)){
            this.pontos += 5 * quantidade;
        }else if (FormaPagamentoEnum.DEBITO.equals(formaPagamentoEnum)){
            this.pontos += 8 * quantidade;
        }

    }

}
