package br.com.triersistemas.delivery;

public enum TipoProdutoEnum {

    BELEZA_PERFUMARIA("Beleza & Perfumaria"),
    MERCEARIA("Mercearia"),
    HIGIENE("Higiene");

    public String tipoProduto;

    TipoProdutoEnum(String descricao) {
        tipoProduto = descricao;
    }
}
