CREATE SEQUENCE IF NOT EXISTS customer_seq;

CREATE TABLE IF NOT EXISTS customers (
    customer_id BIGINT NOT NULL DEFAULT nextval('customer_seq') PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    balance DOUBLE PRECISION NOT NULL
    );

CREATE SEQUENCE IF NOT EXISTS transaction_seq;

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id BIGINT NOT NULL DEFAULT nextval('transaction_seq') PRIMARY KEY,
    name_transfer_from VARCHAR(100) NOT NULL,
    name_transfer_to VARCHAR(100) NOT NULL,
    customer_id_from BIGINT NOT NUll,
    customer_id_to BIGINT NOT NUll,
    transfer_amount DOUBLE PRECISION NOT NULL
);
