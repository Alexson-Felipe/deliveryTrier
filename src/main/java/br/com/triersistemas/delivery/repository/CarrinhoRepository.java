package br.com.triersistemas.delivery.repository;

import br.com.triersistemas.delivery.domain.Carrinho;
import br.com.triersistemas.delivery.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarrinhoRepository {

    List<Carrinho> consultar();

    Optional<Carrinho> consultar(UUID id);

    Optional<Carrinho> consultarProdutoCarrinho(UUID id);

    void cadastrar(Carrinho carrinho);

    void remover(Carrinho carrinho);

}
