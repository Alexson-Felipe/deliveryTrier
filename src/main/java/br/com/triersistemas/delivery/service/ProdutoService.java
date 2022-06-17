package br.com.triersistemas.delivery.service;

import br.com.triersistemas.delivery.domain.Produto;
import br.com.triersistemas.delivery.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<Produto> consultar();

    Produto consultar(UUID id);

    Produto cadastrar(ProdutoModel model);

    Produto alterar(UUID id, ProdutoModel model);

    Produto remover(UUID id);


}
