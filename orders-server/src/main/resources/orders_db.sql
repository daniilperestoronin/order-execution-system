CREATE DATABASE order_database;
CREATE USER order_user WITH password 'qwerty';
GRANT ALL ON DATABASE order_database TO order_user;

CREATE TYPE CLIENT_TYPE AS ENUM ('CUSTOMER','EXECUTOR');

CREATE TABLE order (
  id SERIAL PRIMARY KEY,
  id_customer integer REFERENCES users,
  id_executor REFERENCES users,
  address CHAR(64),
  description VARCHAR(64),
  coordinates point);

CREATE TABLE client (
	id SERIAL PRIMARY KEY,
	id_personal_information integer REFERENCES personal_information,
	client_type CLIENT_TYPE NOT NULL,
	coordinates point;
);

CREATE TABLE personal_information (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    middle_name VARCHAR(64),
    identifier VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL;
);
