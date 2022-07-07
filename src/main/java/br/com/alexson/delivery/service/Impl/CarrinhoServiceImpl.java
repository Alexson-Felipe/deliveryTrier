package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Carrinho;
import br.com.alexson.delivery.domain.Cupom;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.*;
import br.com.alexson.delivery.repository.CarrinhoRepository;
import br.com.alexson.delivery.service.CarrinhoService;
import br.com.alexson.delivery.service.ClienteService;
import br.com.alexson.delivery.service.CupomService;
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
    private CupomService cupomService;

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
    public Carrinho adicionarProdutos(UUID id, ItemCarrinhoModel model) {
        var carrinho = carrinhoRepository.consultar(id).orElseThrow(NaoExisteException::new);
        var produto = produtoService.consultar(model.getIdProduto());
        //carrinho.adicionarProduto(produto, model.getQtd());
        carrinho.adicionarProduto(produto);
        return carrinho;
    }

    @Override
    public Carrinho removerProdutos(UUID id, ItemCarrinhoModel model) {

        var carrinho = carrinhoRepository.consultar(id).orElseThrow(NaoExisteException::new);

        carrinho.removerProduto(id, model);

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
        var carrinho = this.consultar(id);
        //var carrinho = carrinhoRepository.consultar(id)
                //.orElseThrow(NaoExisteException::new);

        //var cupom = cupomService.consultar(model.getIdCupom());

        return carrinho.pagar(id, model.getFormaPagamentoEnum());
    }
}
