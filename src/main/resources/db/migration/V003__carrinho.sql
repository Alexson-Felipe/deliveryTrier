CREATE TABLE carrinho(
    id UUID PRIMARY KEY,
    cliente_id UUID REFERENCES cliente(id),
    total NUMERIC(10,2),
    status VARCHAR NOT NULL
);

CREATE TABLE carrinho_produto(
        carrinho_id UUID REFERENCES carrinho(id),
        produto_id UUID REFERENCES produto(id)

)