CREATE TABLE produto_alterado
(
    id_produto  uuid,
    nome_antes  VARCHAR(255),
    nome_atual  VARCHAR(255),
    preco_antes NUMERIC(5, 2),
    preco_atual NUMERIC(5, 2),
    tipo_antes  VARCHAR(255),
    tipo_atual  VARCHAR(255),
    data_alteracao timestamp
);

CREATE OR REPLACE FUNCTION cria_tabela_dados_alterado_produto() RETURNS TRIGGER AS
$$
BEGIN
    IF (TG_OP = 'UPDATE') THEN
        INSERT INTO produto_alterado(id_produto, nome_antes, nome_atual, preco_antes, preco_atual, tipo_antes,
                                     tipo_atual, data_alteracao)
        VALUES(OLD.id, OLD.nome, NEW.nome, OLD.preco,NEW.preco,OLD.tipo,NEW.tipo, now());
end if;
RETURN NEW;
end;
$$ language plpgsql;

CREATE TRIGGER cria_tabela_dados_alterado_produto_tg
    AFTER UPDATE
    ON produto
    FOR EACH ROW
    EXECUTE PROCEDURE cria_tabela_dados_alterado_produto();
