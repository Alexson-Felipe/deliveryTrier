package br.com.alexson.delivery.service;

import br.com.alexson.delivery.model.ProdutoModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<ProdutoModel> consultar();

    ProdutoModel consultar(UUID id);
    List<ProdutoModel> consultar(List<UUID> ids);

    List<ProdutoModel> findByTipo(String tipo);
    List<ProdutoModel> buscarPeloPrecoMaiorQue(BigDecimal preco);

    ProdutoModel cadastrar(ProdutoModel model);

    ProdutoModel alterar(ProdutoModel model);

    ProdutoModel remover(UUID id);



}
