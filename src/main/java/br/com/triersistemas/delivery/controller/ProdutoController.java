package br.com.triersistemas.delivery.controller;

import br.com.triersistemas.delivery.domain.Cliente;
import br.com.triersistemas.delivery.domain.Produto;
import br.com.triersistemas.delivery.model.ProdutoModel;
import br.com.triersistemas.delivery.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/consultar")
    public List<Produto> consultar(){
        return produtoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody ProdutoModel model){
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Produto alterar(@PathVariable UUID id, @RequestBody ProdutoModel model){
        return  produtoService.alterar(id, model);
    }

}
