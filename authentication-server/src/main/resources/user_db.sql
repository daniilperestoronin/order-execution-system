CREATE DATABASE user_database;
CREATE USER user_db WITH password 'user_db';
GRANT ALL ON DATABASE order_database TO order_user;

CREATE TYPE CLIENT_TYPE AS ENUM ('CUSTOMER','EXECUTOR');

CREATE TABLE users (
	id bigserial PRIMARY KEY,
	first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    middle_name VARCHAR(64),
    client_type CLIENT_TYPE NOT NULL,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL);

