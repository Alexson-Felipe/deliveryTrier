package br.com.alexson.delivery.model;

import br.com.alexson.delivery.domain.Carrinho;
import br.com.alexson.delivery.domain.Cliente;
import br.com.alexson.delivery.domain.ItemCarrinho;
import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.enums.StatusCarrinhoEnum;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
public class CarrinhoModel {

    private UUID id;
    private Cliente cliente;
    private String status;
    private List<ItemCarrinhoModel> itens;
    private BigDecimal total;


    public CarrinhoModel(Carrinho carrinho){
        this.id = carrinho.getId();
        this.cliente = carrinho.getCliente();
        this.status = carrinho.getStatus().name();
        this.itens = criarListaItens(carrinho.getItens());
        this.total = carrinho.getTotal();
    }

    private List<ItemCarrinhoModel> criarListaItens(List<ItemCarrinho> itemCarrinhos){
        if (Objects.nonNull(itemCarrinhos) && !itemCarrinhos.isEmpty()){
            return itemCarrinhos.stream().map(ItemCarrinhoModel::new).toList();
        }else{
            return new ArrayList<>();
        }
    }

}
