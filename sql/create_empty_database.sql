DROP DATABASE IF EXISTS db_jpa_crud;
CREATE DATABASE db_jpa_crud;

USE db_jpa_crud;

CREATE TABLE products (
  id bigint not null auto_increment,
  name varchar(45),
  price int,
  description text,
  primary key (id)
);