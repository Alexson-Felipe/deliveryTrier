/*
package br.com.alexson.delivery.controller;

import br.com.alexson.delivery.domain.Carrinho;
import br.com.alexson.delivery.model.*;
import br.com.alexson.delivery.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoService carrinhoService;

    @GetMapping("/consultar")
    public List<CarrinhoModel> consultar(){
        return carrinhoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public CarrinhoModel consultar(@PathVariable UUID id){
        return carrinhoService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public CarrinhoModel cadastrar(@RequestBody CarrinhoModel model){
        return carrinhoService.cadastrar(model);
    }

    @PutMapping("/adicionar-produtos/{id}")
    public CarrinhoModel adicionarProdutos(@PathVariable UUID id, @RequestBody AdicionarCarrinhoModel model){
        return carrinhoService.adicionarProdutos(id, model);
    }

    @PutMapping("/remover-produto/{id}")
    public CarrinhoModel removerProdutos(@PathVariable UUID id, @RequestBody ItemCarrinhoModel model){
        return carrinhoService.removerProdutos(id, model);
    }



    @PutMapping("/alterar")
    public CarrinhoModel alterar(@RequestBody CarrinhoModel model){
        return carrinhoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public CarrinhoModel remover(@PathVariable UUID id){
        return carrinhoService.remover(id);
    }



    @PutMapping("/pagar/{id}")
    public CarrinhoModel pagar(@PathVariable UUID id, @RequestBody @Valid PagarCarrinhoModel model) {
        return carrinhoService.pagar(id, model);
    }


}
*/
