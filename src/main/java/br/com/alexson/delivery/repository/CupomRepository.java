package br.com.alexson.delivery.repository;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.domain.Cupom;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CupomRepository {

    List<Cupom> consultar();

    Optional<Cupom> consultar(UUID id);

    void cadastrar(Cupom cupom);

    void remover(Cupom cupom);

}
