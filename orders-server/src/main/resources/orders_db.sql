CREATE DATABASE order_database;
CREATE USER order_user WITH password 'order_user';
GRANT ALL ON DATABASE order_database TO order_user;

CREATE TYPE CLIENT_TYPE AS ENUM ('CUSTOMER','EXECUTOR');

CREATE TABLE personal_information (
	id bigserial PRIMARY KEY,
	first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    middle_name VARCHAR(64),
    identifier VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL);

CREATE TABLE clients (
	id bigserial PRIMARY KEY,
	id_personal_information bigserial REFERENCES personal_information,
	client_type CLIENT_TYPE NOT NULL,
	coordinates point);

CREATE TABLE orders (
  id bigserial PRIMARY KEY,
  id_customer bigserial REFERENCES clients,
  id_executor bigserial REFERENCES clients,
  address CHAR(64),
  description VARCHAR(64),
  coordinates point);
