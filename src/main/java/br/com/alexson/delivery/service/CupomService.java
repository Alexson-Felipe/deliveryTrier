package br.com.alexson.delivery.service;

import br.com.alexson.delivery.domain.Cupom;
import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.model.CupomModel;

import java.util.List;
import java.util.UUID;

public interface CupomService {

    List<Cupom> consultar();

    Cupom consultar(UUID id);

    Cupom cadastrar(CupomModel model);

    Cupom remover(UUID id);

}
