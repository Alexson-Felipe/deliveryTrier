package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {

    List<Cliente> consultar();

    Optional<Cliente> consultar(UUID id);

    void cadastrar(Cliente cliente);

    void remover(Cliente cliente);

}
