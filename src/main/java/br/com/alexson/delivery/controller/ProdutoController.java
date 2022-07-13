package br.com.alexson.delivery.controller;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.helper.Util;
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
    public List<ProdutoModel> consultar() {
        return produtoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public ProdutoModel consultar(@PathVariable UUID id) {
        return produtoService.consultar(id);
    }

    @PostMapping("/consultar")
    public List<ProdutoModel> consultar(@RequestBody List<UUID> ids) {
        return produtoService.consultar(ids);
    }

    @PostMapping("/cadastrar")
    public ProdutoModel cadastrar(@RequestBody @Valid ProdutoModel model) {
        return produtoService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public ProdutoModel alterar(@RequestBody ProdutoModel model) {
        return produtoService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ProdutoModel remover(@PathVariable UUID id){
        return produtoService.remover(id);
    }

}
