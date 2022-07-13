package br.com.alexson.delivery.domain;

import br.com.alexson.delivery.enums.FormaPagamentoEnum;
import br.com.alexson.delivery.model.ClienteModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "cliente")
public class Cliente extends Pessoa {

    @Column(name = "pontos", insertable = false)
    private Integer pontos = 0;

    /*
    public Cliente() {
        super();
        this.pontos = 0;
    }



    public Cliente(String nome, String cpf) {
        super(nome, cpf);
        this.pontos = 0;
    }

     */

    public Cliente(ClienteModel model){
        super(model.getNome(), model.getCpf());
        this.pontos = model.getPontos();
    }

    protected void adicionarPontos(FormaPagamentoEnum formaPagamentoEnum, Integer quantidade) {
        if (FormaPagamentoEnum.CREDITO.equals(formaPagamentoEnum)){
            this.pontos += 5 * quantidade;
        }else if (FormaPagamentoEnum.DEBITO.equals(formaPagamentoEnum)){
            this.pontos += 8 * quantidade;
        }

    }

}
