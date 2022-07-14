package br.com.alexson.delivery.repository.Impl;

import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.domain.QCliente;
import br.com.alexson.delivery.repository.ClienteRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Cliente> consultarPeloNome(String nome) {
        final QCliente cliente = QCliente.cliente;

        BooleanBuilder where = new BooleanBuilder();
        where.and(cliente.nome.containsIgnoreCase(nome));

        return new JPAQuery<Cliente>(em)
                .select(cliente)
                .from(cliente)
                .where(where)
                .fetch();
    }








/*
    private static final List<Cliente> LIST = new ArrayList<>();

    @Override
    public List<Cliente> consultar() {
        return LIST;
    }

    @Override
    public Optional<Cliente> consultar(UUID id) {
        return LIST.stream()
                .filter(cliente -> id.equals(cliente.getId()))
                .findFirst();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        LIST.add(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        LIST.remove(cliente);
    }

 */
}
