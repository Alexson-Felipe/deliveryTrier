package br.com.triersistemas.delivery.repository.Impl;

import br.com.triersistemas.delivery.domain.Carrinho;
import br.com.triersistemas.delivery.domain.Produto;
import br.com.triersistemas.delivery.repository.CarrinhoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarrinhoRepositoryImpl implements CarrinhoRepository {

    private static final List<Carrinho> LIST = new ArrayList<>();

    @Override
    public List<Carrinho> consultar() {
        return LIST;
    }

    @Override
    public Optional<Carrinho> consultar(UUID id) {
        return LIST.stream()
                .filter(carrinho -> id.equals(carrinho.getId()))
                .findFirst();
    }

    @Override
    public Optional<Carrinho> consultarProdutoCarrinho(UUID id) {
        //ARRUMAR
        var carrinhoProduto = LIST.stream()
                .filter(produto -> id.equals(produto.getProdutos()))
                .findFirst();

        return carrinhoProduto;
    }

    @Override
    public void cadastrar(Carrinho carrinho) {
        LIST.add(carrinho);
    }

    @Override
    public void remover(Carrinho carrinho) {
        LIST.remove(carrinho);
    }
}
