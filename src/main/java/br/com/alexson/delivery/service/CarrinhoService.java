package br.com.alexson.delivery.service;

import br.com.alexson.delivery.domain.Carrinho;
import br.com.alexson.delivery.model.*;

import java.util.List;
import java.util.UUID;

public interface CarrinhoService {

    List<Carrinho> consultar();

    Carrinho consultar(UUID id);

    Carrinho cadastrar(CarrinhoModel model);

    Carrinho adicionarProdutos(UUID id, ItemCarrinhoModel model);

    Carrinho alterar(UUID id, CarrinhoModel model);

    Carrinho removerProdutos(UUID id, RemoverProdutoCarrinhoModel model);

    Carrinho remover(UUID id);

    Carrinho pagar(UUID id, PagarCarrinhoModel model);

}
