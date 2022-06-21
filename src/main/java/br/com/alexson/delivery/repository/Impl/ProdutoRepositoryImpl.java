package br.com.alexson.delivery.repository.Impl;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.repository.ProdutoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private static final List<Produto> LIST = new ArrayList<>();

    @Override
    public List<Produto> consultar() {
        return LIST;
    }

    @Override
    public Optional<Produto> consultar(UUID id) {
        return LIST.stream()
                .filter(cliente -> id.equals(cliente.getId()))
                .findFirst();
    }

    @Override
    public List<Produto> consultar(List<UUID> ids) {
        return ids.stream()
                .map(id -> this.consultar(id).orElseThrow(NaoExisteException::new)).toList();
    }

    @Override
    public void cadastrar(Produto produto) {
        LIST.add(produto);
    }

    @Override
    public void remover(Produto produto) {
        LIST.remove(produto);
    }
}
