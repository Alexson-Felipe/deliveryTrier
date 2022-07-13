package br.com.alexson.delivery.service;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<ProdutoModel> consultar();

    ProdutoModel consultar(UUID id);
    List<ProdutoModel> consultar(List<UUID> ids);

    ProdutoModel cadastrar(ProdutoModel model);

    ProdutoModel alterar(ProdutoModel model);

    ProdutoModel remover(UUID id);


}
