package br.com.triersistemas.delivery.service;

import br.com.triersistemas.delivery.domain.Carrinho;
import br.com.triersistemas.delivery.model.AdicionarCarrinhoModel;
import br.com.triersistemas.delivery.model.CarrinhoModel;
import br.com.triersistemas.delivery.model.RemoverProdutoCarrinhoModel;

import java.util.List;
import java.util.UUID;

public interface CarrinhoService {

    List<Carrinho> consultar();

    Carrinho consultar(UUID id);

    Carrinho cadastrar(CarrinhoModel model);

    Carrinho adicionarProdutos(UUID id, AdicionarCarrinhoModel model);

    Carrinho alterar(UUID id, CarrinhoModel model);

    Carrinho removerProdutos(UUID id, RemoverProdutoCarrinhoModel model);

    Carrinho remover(UUID id);

}
