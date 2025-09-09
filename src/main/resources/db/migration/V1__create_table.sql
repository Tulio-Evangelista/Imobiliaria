CREATE TABLE tb_clientes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf CHAR(11) UNIQUE,
    telefone VARCHAR(20),
    email VARCHAR(50) UNIQUE,
    status_cliente VARCHAR(20),
    password VARCHAR(100) NOT NULL
);

CREATE TABLE tb_casa (
    id BIGSERIAL PRIMARY KEY,
    cidade VARCHAR(255),
    quantidade_de_quartos INT,
    valor_do_aluguel INT,
    img_casa VARCHAR(255),
    status_imovel VARCHAR(20),
    cliente_id BIGINT REFERENCES tb_clientes(id)
);

CREATE TABLE tb_apartamento (
    id BIGSERIAL PRIMARY KEY,
    endereco VARCHAR(255),
    numero_de_quartos INT,
    valor_do_aluguel INT,
    valor_do_condominio INT,
    img_apartamento VARCHAR(255),
    aceita_pet BOOLEAN,
    status_imovel VARCHAR(20),
    cliente_id BIGINT REFERENCES tb_clientes(id)
);
