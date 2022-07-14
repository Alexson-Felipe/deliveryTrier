package br.com.alexson.delivery.service;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.model.AlterarClienteModel;
import br.com.alexson.delivery.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<ClienteModel> consultar();

    ClienteModel consultar(UUID id);

    ClienteModel cadastrar(ClienteModel model);

    List<Cliente> consultarPeloNomeCliente(String nome);

    ClienteModel alterar(ClienteModel model);

    ClienteModel remover(UUID id);

}
