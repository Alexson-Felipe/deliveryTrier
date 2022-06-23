package br.com.alexson.delivery.model;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
public class PagarCarrinhoModel {


    private UUID idCupom;

    @NotNull
    private FormaPagamentoEnum formaPagamentoEnum;

}