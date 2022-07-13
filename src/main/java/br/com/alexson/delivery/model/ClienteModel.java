package br.com.alexson.delivery.model;

import br.com.alexson.delivery.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class ClienteModel {

    private UUID id;
    private String nome;
    private String cpf;
    private Integer pontos = 0;

    public ClienteModel(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.pontos = cliente.getPontos();
    }

}
