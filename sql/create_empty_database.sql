DROP DATABASE IF EXISTS db_jpa_crud;
CREATE DATABASE db_jpa_crud;

USE db_jpa_crud;

CREATE TABLE products (
  id bigint not null auto_increment,
  name varchar(45) not null,
  price int not null,
  description text not null,
  primary key (id)
);