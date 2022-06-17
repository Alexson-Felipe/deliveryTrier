package br.com.triersistemas.delivery.model;

import br.com.triersistemas.delivery.domain.Produto;
import lombok.Getter;

import java.util.List;

@Getter
public class CarrinhoModel {

    List<Produto> produto;

}
