package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.exceptions.NaoExisteException;
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
    public List<ClienteModel> consultar() {
        return clienteRepository
                .findAll()
                .stream()
                .map(ClienteModel::new)
                .toList();
    }

    @Override
    public ClienteModel consultar(UUID id) {
        return new ClienteModel(this.buscarClienteId(id));
    }

    public List<Cliente> consultarPeloNomeCliente(String nome){
        return this.clienteRepository.consultarPeloNome(nome);
    }

    @Override
    public ClienteModel cadastrar(ClienteModel model) {
        var cliente = new Cliente(model);
        return new ClienteModel(clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel alterar(ClienteModel model) {
        var cliente = this.buscarClienteId(model.getId());
        cliente.editar(model.getNome(), model.getCpf());
        return new ClienteModel(this.clienteRepository.save(cliente));
    }

    @Override
    public ClienteModel remover(UUID id) {
        Cliente cliente = this.buscarClienteId(id);
        clienteRepository.delete(cliente);
        return new ClienteModel(cliente);
    }

    private Cliente buscarClienteId(UUID id) {
        return clienteRepository
                .findById(id)
                .orElseThrow(NaoExisteException::new);
    }
}
