package br.com.triersistemas.delivery.repository;

import br.com.triersistemas.delivery.domain.Cliente;
import br.com.triersistemas.delivery.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {

    List<Produto> consultar();

    Optional<Produto> consultar(UUID id);

    void cadastrar(Produto produto);

    void remover(Produto produto);

}
