package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Carrinho;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.AdicionarCarrinhoModel;
import br.com.alexson.delivery.model.CarrinhoModel;
import br.com.alexson.delivery.model.PagarCarrinhoModel;
import br.com.alexson.delivery.model.RemoverProdutoCarrinhoModel;
import br.com.alexson.delivery.repository.CarrinhoRepository;
import br.com.alexson.delivery.service.CarrinhoService;
import br.com.alexson.delivery.service.ClienteService;
import br.com.alexson.delivery.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public List<Carrinho> consultar() {
        return carrinhoRepository.consultar();
    }

    @Override
    public Carrinho consultar(UUID id) {
        return carrinhoRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Carrinho cadastrar(CarrinhoModel model) {
        var cliente = clienteService.consultar(model.getIdCliente());
        var carrinho = new Carrinho(cliente);
        carrinhoRepository.cadastrar(carrinho);
        return carrinho;
    }

    @Override
    public Carrinho adicionarProdutos(UUID id, AdicionarCarrinhoModel model) {
        var carrinho = carrinhoRepository.consultar(id).orElseThrow(NaoExisteException::new);
        var produtos = produtoService.consultar(model.getIdProdutos());
        carrinho.adicionarProduto(produtos);
        return carrinho;
    }

    @Override
    public Carrinho removerProdutos(UUID id, RemoverProdutoCarrinhoModel model) {

        var carrinho = carrinhoRepository.consultar(id).orElseThrow(NaoExisteException::new);
        var carrinhoProduto = carrinhoRepository.consultarProdutoCarrinho(model.getIdProduto()).orElseThrow(NaoExisteException::new);

        carrinho.removerProduto(carrinhoProduto);

        return carrinho;
    }

    @Override
    public Carrinho alterar(UUID id, CarrinhoModel model) {
        var carrinho = this.consultar(id);
        carrinhoRepository.cadastrar(carrinho);
        return carrinho;
    }

    @Override
    public Carrinho remover(UUID id) {
        Carrinho carrinho = this.consultar(id);
        carrinhoRepository.remover(carrinho);
        return carrinho;
    }

    @Override
    public Carrinho pagar(UUID id, PagarCarrinhoModel model) {
        var carrinho = carrinhoRepository.consultar(id)
                .orElseThrow(NaoExisteException::new);
        return carrinho.pagar(id, model.getIdCupom(), model.getFormaPagamentoEnum());
    }
}