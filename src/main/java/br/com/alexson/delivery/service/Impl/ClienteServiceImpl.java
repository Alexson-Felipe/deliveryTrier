package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.AlterarClienteModel;
import br.com.alexson.delivery.model.ClienteModel;
import br.com.alexson.delivery.repository.ClienteRepository;
import br.com.alexson.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> consultar() {
        return clienteRepository.consultar();
    }

    @Override
    public Cliente consultar(UUID id) {
        return clienteRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Cliente cadastrar(ClienteModel model) {
        var cliente = new Cliente(model.getNome(), model.getCpf(), model.getSenha());
        clienteRepository.cadastrar(cliente);
        return cliente;
    }

    @Override
    public Cliente alterar(UUID id, AlterarClienteModel model) {
        var cliente = this.consultar(id);
        cliente.editar(model.getNome(), model.getSenha());
        return cliente;
    }

    @Override
    public Cliente remover(UUID id) {
        Cliente cliente = this.consultar(id);
        clienteRepository.remover(cliente);
        return cliente;
    }
}
