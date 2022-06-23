package br.com.alexson.delivery.controller;

import br.com.alexson.delivery.domain.Cupom;
import br.com.alexson.delivery.model.CupomModel;
import br.com.alexson.delivery.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    @Autowired
    private CupomService cupomService;

    @GetMapping("/consultar")
    public List<Cupom> consultar() {
        return cupomService.consultar();
    }

    @PostMapping("/cadastrar")
    public Cupom cadastrar(@RequestBody @Valid CupomModel model) {
        return cupomService.cadastrar(model);
    }

    @DeleteMapping("/remover/{id}")
    public Cupom remover(@PathVariable UUID id){
        return cupomService.remover(id);
    }
}
