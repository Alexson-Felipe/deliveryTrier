package br.com.alexson.delivery.repository.Impl;

import br.com.alexson.delivery.domain.Cupom;
import br.com.alexson.delivery.repository.CupomRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CupomRepositoryImpl implements CupomRepository {

    private static final List<Cupom> LIST = new ArrayList<>();

    @Override
    public List<Cupom> consultar() {
        return LIST;
    }

    @Override
    public Optional<Cupom> consultar(UUID id) {
        return LIST.stream()
                .filter(cupom -> id.equals(cupom.getId()))
                .findFirst();
    }

    @Override
    public void cadastrar(Cupom cupom) {
        LIST.add(cupom);
    }

    @Override
    public void remover(Cupom cupom) {
        LIST.remove(cupom);
    }
}
