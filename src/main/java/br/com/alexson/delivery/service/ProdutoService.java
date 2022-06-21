package br.com.alexson.delivery.service;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<Produto> consultar();

    Produto consultar(UUID id);
    List<Produto> consultar(List<UUID> ids);

    Produto cadastrar(ProdutoModel model);

    Produto alterar(UUID id, ProdutoModel model);

    Produto remover(UUID id);


}
