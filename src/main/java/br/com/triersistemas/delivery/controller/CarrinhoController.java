package br.com.triersistemas.delivery.controller;

import br.com.triersistemas.delivery.domain.Carrinho;
import br.com.triersistemas.delivery.model.AdicionarCarrinhoModel;
import br.com.triersistemas.delivery.model.CarrinhoModel;
import br.com.triersistemas.delivery.model.RemoverProdutoCarrinhoModel;
import br.com.triersistemas.delivery.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoService carrinhoService;

    @GetMapping("/consultar")
    public List<Carrinho> consultar(){
        return carrinhoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public Carrinho consultar(@PathVariable UUID id){
        return carrinhoService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public Carrinho cadastrar(@RequestBody CarrinhoModel model){
        return carrinhoService.cadastrar(model);
    }

    @PutMapping("/adicionar-produtos/{id}")
    public Carrinho adicionarProdutos(@PathVariable UUID id, @RequestBody AdicionarCarrinhoModel model){
        return carrinhoService.adicionarProdutos(id, model);
    }

    @PutMapping("/remover-produtos/{id}")
    public Carrinho removerProdutos(@PathVariable UUID id, @RequestBody RemoverProdutoCarrinhoModel model){
        return carrinhoService.removerProdutos(id, model);
    }


    @PutMapping("/alterar/{id}")
    public Carrinho alterar(@PathVariable UUID id, @RequestBody CarrinhoModel model){
        return carrinhoService.alterar(id, model);
    }

    @DeleteMapping("/remover/{id}")
    public Carrinho remover(@PathVariable UUID id){
        return carrinhoService.remover(id);
    }

}
