package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.enums.TipoProdutoEnum;
import br.com.alexson.delivery.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
    List<ProdutoModel> findByTipo(TipoProdutoEnum tipo);

    @Query(value = "SELECT * FROM produto WHERE preco > ?1", nativeQuery = true)
    List<Produto> buscarPeloPrecoMaiorQue(BigDecimal preco);

    /*
    List<ProdutoModel> consultar();

    Optional<ProdutoModel> consultar(UUID id);
    List<ProdutoModel> consultar(List<UUID> ids);

    void cadastrar(ProdutoModel model);
    void remover(ProdutoModel model);

     */

}
