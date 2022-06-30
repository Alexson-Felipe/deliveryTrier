package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.helper.Util;
import br.com.alexson.delivery.model.ProdutoModel;
import br.com.alexson.delivery.repository.ProdutoRepository;
import br.com.alexson.delivery.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public List<Produto> consultar() {
        return produtoRepository.consultar();
    }

    @Override
    public Produto consultar(UUID id) {
        return produtoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public List<Produto> consultar(List<UUID> ids) {

        return produtoRepository.consultar(ids);
    }

    @Override
    public Produto cadastrar(ProdutoModel model) {
        var produto = new Produto(model.getNome(), model.getPreco(), model.getTipo());
        produtoRepository.cadastrar(produto);
        return produto;
    }

    @Override
    public Produto alterar(UUID id, ProdutoModel model) {
        var produto = this.consultar(id);
        produto.editar(model.getNome(), model.getPreco(), model.getTipo());
        return produto;
    }

    @Override
    public Produto remover(UUID id) {
        Produto produto = this.consultar(id);
        produtoRepository.remover(produto);
        return produto;
    }
}
