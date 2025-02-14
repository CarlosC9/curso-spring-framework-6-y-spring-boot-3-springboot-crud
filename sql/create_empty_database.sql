drop database if exists db_jpa_crud;
create database db_jpa_crud;

use db_jpa_crud;

create table products
(
  id          bigint      not null auto_increment,
  name        varchar(45) not null,
  price       int         not null,
  description text        not null,
  sku         varchar(45),
  primary key (id)
);

create table users
(
  id       bigint       not null auto_increment,
  username varchar(18)  not null,
  password varchar(255) not null,
  enabled  boolean      not null default true,
  primary key (id)
);

create table roles
(
  id bigint not null auto_increment,
  name varchar(45) not null,
  primary key (id)
);

create table users_roles (
  user_id bigint not null,
  rol_id bigint not null,
  primary key (user_id, rol_id)
);

alter table users_roles
  add foreign key (user_id) references users(id) ON DELETE CASCADE,
  add foreign key (rol_id) references roles(id) ON DELETE CASCADE;