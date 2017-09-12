CREATE DATABASE user_database;
CREATE USER user_db WITH password 'user_db';
GRANT ALL ON DATABASE order_database TO order_user;

CREATE TYPE USER_TYPE AS ENUM ('CUSTOMER','EXECUTOR', 'ADMINISTRATOR');

CREATE TABLE users (
	id bigserial PRIMARY KEY,
	first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    middle_name VARCHAR(64),
    user_type USER_TYPE NOT NULL,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL);

