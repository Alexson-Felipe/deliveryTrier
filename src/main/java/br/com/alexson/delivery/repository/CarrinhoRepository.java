package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Carrinho;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarrinhoRepository {

    List<Carrinho> consultar();

    Optional<Carrinho> consultar(UUID id);

    void cadastrar(Carrinho carrinho);

    void remover(Carrinho carrinho);

}
