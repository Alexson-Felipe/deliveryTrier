CREATE TABLE produto(
    id uuid PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(5,2) NOT NULL,
    tipo VARCHAR(255) NOT NULL
);