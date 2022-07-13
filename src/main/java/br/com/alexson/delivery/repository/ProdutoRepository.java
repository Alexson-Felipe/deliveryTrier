package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    /*
    List<ProdutoModel> consultar();

    Optional<ProdutoModel> consultar(UUID id);
    List<ProdutoModel> consultar(List<UUID> ids);

    void cadastrar(ProdutoModel model);
    void remover(ProdutoModel model);

     */

}
