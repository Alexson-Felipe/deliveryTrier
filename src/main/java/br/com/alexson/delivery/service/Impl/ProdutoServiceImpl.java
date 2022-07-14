package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.enums.TipoProdutoEnum;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.ProdutoModel;
import br.com.alexson.delivery.repository.ProdutoRepository;
import br.com.alexson.delivery.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public List<ProdutoModel> consultar() {
        return produtoRepository
                .findAll()
                .stream()
                .map(ProdutoModel::new)
                .toList();
    }

    @Override
    public ProdutoModel consultar(UUID id) {
        return new ProdutoModel(this.buscarProdutoId(id));
    }

    @Override
    public List<ProdutoModel> consultar(List<UUID> ids) {

        return produtoRepository
                .findAllById(ids)
                .stream()
                .map(ProdutoModel::new)
                .toList();
    }

    @Override
    public List<ProdutoModel> findByTipo(String tipo) {

        return this.produtoRepository.findByTipo(TipoProdutoEnum.valueOf(tipo));
    }

    @Override
    public List<ProdutoModel> buscarPeloPrecoMaiorQue(BigDecimal preco) {
        return this.produtoRepository.buscarPeloPrecoMaiorQue(preco).stream().map(ProdutoModel::new).toList();
    }

    protected List<Produto> consultarProdutos(List<UUID> idProdutos) {
        return produtoRepository.findAllById(idProdutos);
    }

    @Override
    public ProdutoModel cadastrar(ProdutoModel model) {
        var produto = new Produto(model);
        return new ProdutoModel(produtoRepository.save(produto));
    }

    @Override
    public ProdutoModel alterar(ProdutoModel model) {
        var produto = this.buscarProdutoId(model.getId());
        produto.editar(model.getNome(), model.getPreco(), model.getTipo());
        return new ProdutoModel(this.produtoRepository.save(produto));
    }

    @Override
    public ProdutoModel remover(UUID id) {
        Produto produto = this.buscarProdutoId(id);
        produtoRepository.delete(produto);
        return new ProdutoModel(produto);
    }

    private Produto buscarProdutoId(UUID id) {
        return produtoRepository
                .findById(id)
                .orElseThrow(NaoExisteException::new);
    }
}
