package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
/*
    List<Cliente> consultar();

    Optional<Cliente> consultar(UUID id);

    void cadastrar(Cliente cliente);

    void remover(Cliente cliente);
 */

}
