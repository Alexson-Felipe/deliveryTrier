package br.com.alexson.delivery.service;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.model.AlterarClienteModel;
import br.com.alexson.delivery.model.ClienteModel;

import java.util.List;
import java.util.UUID;

public interface ClienteService {

    List<Cliente> consultar();

    Cliente consultar(UUID id);

    Cliente cadastrar(ClienteModel model);

    Cliente alterar(UUID id, AlterarClienteModel model);

    Cliente remover(UUID id);

}
