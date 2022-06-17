package br.com.triersistemas.delivery.service.Impl;

import br.com.triersistemas.delivery.domain.Cliente;
import br.com.triersistemas.delivery.exceptions.NaoExisteException;
import br.com.triersistemas.delivery.model.ClienteModel;
import br.com.triersistemas.delivery.repository.ClienteRepository;
import br.com.triersistemas.delivery.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

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
    public Cliente alterar(UUID id, ClienteModel model) {
        var cliente = this.consultar(id);
        clienteRepository.cadastrar(cliente);
        return cliente;
    }

    @Override
    public Cliente remover(UUID id) {
        Cliente cliente = this.consultar(id);
        clienteRepository.remover(cliente);
        return cliente;
    }
}
