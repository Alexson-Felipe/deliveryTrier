package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Cliente;

import java.util.List;

public interface ClienteRepositoryCustom {

    List<Cliente> consultarPeloNome(String nome);

}
