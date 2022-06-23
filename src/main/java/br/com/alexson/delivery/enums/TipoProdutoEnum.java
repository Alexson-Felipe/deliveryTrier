package br.com.alexson.delivery.enums;

public enum TipoProdutoEnum {

    BELEZA_PERFUMARIA("Beleza & Perfumaria"),
    MERCEARIA("Mercearia"),
    HIGIENE("Higiene");

    private String descricao;

    TipoProdutoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {

        return descricao;
    }
}