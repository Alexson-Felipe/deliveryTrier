package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Carrinho;
import br.com.alexson.delivery.domain.Cupom;
import br.com.alexson.delivery.domain.Produto;
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
/*
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CupomService cupomService;

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;


    @Override
    public List<CarrinhoModel> consultar() {
        //return carrinhoRepository.findAll().stream().map(CarrinhoModel::new).toList();
        return null;
    }

    @Override
    public CarrinhoModel consultar(UUID id) {
        return new CarrinhoModel(this.buscarPorId(id));
    }

    @Override
    public CarrinhoModel cadastrar(CarrinhoModel model) {
        var cliente = clienteService.consultar(model.getId());

        var carrinho = new Carrinho(cliente);

        //return new CarrinhoModel(carrinhoRepository.save(carrinho));
        return new CarrinhoModel(carrinhoRepository.save(carrinho));
    }

    @Override
    public CarrinhoModel adicionarProdutos(UUID id, AdicionarCarrinhoModel model) {
        var carrinho = this.buscarPorId(id);

        var produtos = produtoService.consultar(model.getIdProdutos());


        return new CarrinhoModel(carrinhoRepository.save(carrinho.adicionarProduto(produtos)));
    }

    @Override
    public CarrinhoModel removerProdutos(UUID id, ItemCarrinhoModel model) {

        var carrinho = this.buscarPorId(id);

        carrinho.removerProduto(id, model);

        return new CarrinhoModel(carrinhoRepository.delete(model.));


        return null;
    }

    @Override
    public CarrinhoModel alterar(CarrinhoModel model) {

        var carrinho = this.consultar(id);
        carrinhoRepository.cadastrar(carrinho);


        return null;
    }

    @Override
    public CarrinhoModel remover(UUID id) {

        Carrinho carrinho = this.consultar(id);
        carrinhoRepository.remover(carrinho);


        return null;
    }



    @Override
    public CarrinhoModel pagar(UUID id, PagarCarrinhoModel model) {
        var carrinho = this.buscarPorId(id);
        //var carrinho = carrinhoRepository.consultar(id)
                //.orElseThrow(NaoExisteException::new);

        //var cupom = cupomService.consultar(model.getIdCupom());

        carrinho.pagar(id, model.getFormaPagamentoEnum());
        return new CarrinhoModel(carrinho);

    }

    private Carrinho buscarPorId(UUID id) {
        return carrinhoRepository
                .findById(id)
                .orElseThrow(NaoExisteException::new);
    }
    */
}
