package br.com.triersistemas.delivery.model;

import br.com.triersistemas.delivery.domain.Carrinho;
import br.com.triersistemas.delivery.domain.Produto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClienteModel {

    private String nome;
    private String cpf;
    private String senha;
    //private List<Produto> produto = new ArrayList<>();
    private Carrinho carrinho;

}
