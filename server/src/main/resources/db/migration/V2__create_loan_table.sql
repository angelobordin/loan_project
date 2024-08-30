CREATE TABLE loan (
    id SERIAL PRIMARY KEY,
    data_emprestimo TIMESTAMP NOT NULL,
    data_vencimento TIMESTAMP NOT NULL,
    moeda VARCHAR(3) NOT NULL,
    valor_obtido NUMERIC NOT NULL,
    valor_final NUMERIC NOT NULL,
    customer_id INTEGER,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);
