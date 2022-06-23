package br.com.alexson.delivery.service.Impl;

import br.com.alexson.delivery.domain.Cupom;
import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.exceptions.NaoExisteException;
import br.com.alexson.delivery.model.CupomModel;
import br.com.alexson.delivery.repository.CupomRepository;
import br.com.alexson.delivery.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CupomServiceImpl implements CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    @Override
    public List<Cupom> consultar() {
        return cupomRepository.consultar();
    }

    @Override
    public Cupom consultar(UUID id) {
        return cupomRepository.consultar(id).orElseThrow(NaoExisteException::new);
    }

    @Override
    public Cupom cadastrar(CupomModel model) {
        var cupom = new Cupom(model.getNome(), model.getValorEmPontos(), model.getValorDesconto());
        cupomRepository.cadastrar(cupom);
        return cupom;
    }

    @Override
    public Cupom remover(UUID id) {
        Cupom cupom = this.consultar(id);
        cupomRepository.remover(cupom);
        return cupom;
    }
}
