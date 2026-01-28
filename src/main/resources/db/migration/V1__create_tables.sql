CREATE TABLE clientes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    endereco TEXT,
    senha VARCHAR(255) NOT NULL, -- ADICIONADA
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE emprestimos (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    taxa_juros DECIMAL(5,2) NOT NULL,
    total_com_juros DECIMAL(10,2) NOT NULL,
    parcelas INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cliente
        FOREIGN KEY (cliente_id)
        REFERENCES clientes(id)
);

CREATE TABLE parcelas (
    id BIGSERIAL PRIMARY KEY,
    emprestimo_id BIGINT NOT NULL,
    numero INT NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    vencimento DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    CONSTRAINT fk_emprestimo
        FOREIGN KEY (emprestimo_id)
        REFERENCES emprestimos(id)
);

CREATE TABLE pagamentos (
    id BIGSERIAL PRIMARY KEY,
    parcela_id BIGINT NOT NULL,
    valor_pago DECIMAL(10,2) NOT NULL,
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_parcela
        FOREIGN KEY (parcela_id)
        REFERENCES parcelas(id)
);
