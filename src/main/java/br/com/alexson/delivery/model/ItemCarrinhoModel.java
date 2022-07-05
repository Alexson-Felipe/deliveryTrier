package br.com.alexson.delivery.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ItemCarrinhoModel {

    private UUID idItemCarrinho;
    private UUID idProduto;
    private Integer qtd;

}
