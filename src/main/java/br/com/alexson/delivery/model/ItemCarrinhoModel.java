package br.com.alexson.delivery.model;

import br.com.alexson.delivery.domain.ItemCarrinho;
import br.com.alexson.delivery.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@NoArgsConstructor
@Getter
public class ItemCarrinhoModel {

    private UUID id;
    private UUID idItemCarrinho;
    private UUID idProduto;
    private Integer qtd;
    private ProdutoModel produto;
    private BigDecimal valorTotal;

    public ItemCarrinhoModel(ItemCarrinho itemCarrinho){
        this.id = itemCarrinho.getId();
        this.idItemCarrinho = itemCarrinho.getId();
        this.idProduto = itemCarrinho.getProduto().getId();
        this.qtd = itemCarrinho.getQtd();
        this.produto = itemCarrinho.getProduto();
        this.valorTotal = getValorTotal();
    }

}
