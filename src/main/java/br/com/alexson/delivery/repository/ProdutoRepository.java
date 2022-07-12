package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    List<Produto> consultar();

    Optional<Produto> consultar(UUID id);
    List<Produto> consultar(List<UUID> ids);

    void cadastrar(Produto produto);
    void remover(Produto produto);

}
