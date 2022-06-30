package br.com.alexson.delivery.helper;

import br.com.alexson.delivery.domain.Produto;
import br.com.alexson.delivery.enums.TipoProdutoEnum;
import br.com.alexson.delivery.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Util {

    ProdutoRepository produtoRepository;

    public void cadastraProdutoAutomatico(){

                Produto produtoo = new Produto();
                List<Produto> listaProduto = new ArrayList<>();

              listaProduto.add(new Produto("Shampoo Clear 400ml", BigDecimal.valueOf(20.90), TipoProdutoEnum.BELEZA_PERFUMARIA));
              listaProduto.add(new Produto("Shampoo Seda 325ml", BigDecimal.valueOf(8.89), TipoProdutoEnum.BELEZA_PERFUMARIA));
              listaProduto.add(new Produto("Condicionador Seda 325ml", BigDecimal.valueOf(6.95), TipoProdutoEnum.BELEZA_PERFUMARIA));
              listaProduto.add(new Produto("Ração Three Dogs 10KG", BigDecimal.valueOf(117.99), TipoProdutoEnum.MERCEARIA));
              listaProduto.add(new Produto("Ração Whiskas 10,5KG", BigDecimal.valueOf(152.99), TipoProdutoEnum.MERCEARIA));
              listaProduto.add(new Produto("Arroz 1kg", BigDecimal.valueOf(5.99), TipoProdutoEnum.MERCEARIA));
              listaProduto.add(new Produto("Arroz 5kg", BigDecimal.valueOf(20.90),  TipoProdutoEnum.MERCEARIA));
              listaProduto.add(new Produto("Feijão 1kg", BigDecimal.valueOf(9.89), TipoProdutoEnum.MERCEARIA));
              listaProduto.add(new Produto("Desodorante Rexona 150ml", BigDecimal.valueOf(17.95), TipoProdutoEnum.HIGIENE));
              listaProduto.add(new Produto("Fralda Xg Pampers", BigDecimal.valueOf(74.61), TipoProdutoEnum.HIGIENE));
              listaProduto.add(new Produto("Escova Dental", BigDecimal.valueOf(5.79), TipoProdutoEnum.HIGIENE));

        for (Produto produto: listaProduto) {
            this.produtoRepository.cadastrar(produto);
        }

    }

}
