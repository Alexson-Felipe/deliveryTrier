package br.com.alexson.delivery.controller;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.model.ProdutoModel;
import br.com.alexson.delivery.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/consultar")
    public List<Produto> consultar() {
        return produtoService.consultar();
    }

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody @Valid ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar/{id}")
    public Produto alterar(@PathVariable UUID id, @RequestBody @Valid ProdutoModel model) {
        return produtoService.alterar(id, model);
    }

}
