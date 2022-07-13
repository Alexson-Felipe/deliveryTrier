package br.com.alexson.delivery.controller;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.model.AlterarClienteModel;
import br.com.alexson.delivery.model.ClienteModel;
import br.com.alexson.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/consultar")
    public List<ClienteModel> consultar() {
        return clienteService.consultar();
    }

    @PostMapping("/cadastrar")
    public ClienteModel cadastrar(@RequestBody ClienteModel model) {
        return clienteService.cadastrar(model);
    }

    @PutMapping("/alterar")
    public ClienteModel alterar(@RequestBody ClienteModel model){
        return clienteService.alterar(model);
    }

    @DeleteMapping("/remover/{id}")
    public ClienteModel remover(@PathVariable UUID id){
        return clienteService.remover(id);
    }

}
