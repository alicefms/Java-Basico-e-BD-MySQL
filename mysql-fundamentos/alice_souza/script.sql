use loja ;

create table cliente(
	id int not null auto_increment,
	codigo_cliente varchar (10),
	nome varchar (100),
	razao_social varchar(100),
	data_cadastro date,
	cnpj varchar(20),
	telefone varchar(20),
	primary key(id)
);

insert into cliente(codigo_cliente, nome, razao_social, data_cadastro, cnpj, telefone) 
values ('987', "Ana Rita", 'Areia', now(), '514875453218574', '(84)84784888');

select * from cliente;

create table fornecedor(
	id int not null auto_increment,
	codigo_fornecedor varchar(100),
	nome varchar(100),
	razao_social varchar(100),
	telefone varchar(20),
	primary key(id)
);

create table produto(
	id int not null auto_increment,
	codigo_produto varchar(100),
	descricao varchar(100),
	valor float(10,2),
	situacao varchar(1),
	id_fornecedor int,
	primary key(id)
);

create table venda(
	id int not null auto_increment,
	codigo_venda varchar(100),
	id_cliente int not null, 
	id_fornecedor int not null, 
	id_vendedor int not null, 
	valor float(10,2),
	desconto float(10,2),
	total float(10,2),
	data_venda date,
	primary key(id)
);

drop table venda;

create table item_venda(
	id int not null auto_increment,
	codigo_item_venda int not null, 
	id_produto int not null, 
	valor float(10,2),
	qte int,
	desconto float(10,2),
	primary key(id)
);
-- para atualizar e excluir, DE PREFERENCIA, usar where

update cliente set cnpj = '88888888888'where id =3;

insert into cliente(nome) values ("Alicio");
insert into cliente(nome, data_cadastro, telefone) values ("Alice", now(), '945875412');