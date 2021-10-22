use loja;
create table endereco(
	id int not null auto_increment primary key,
	logradouro varchar(35) not null,
	numero varchar(4) not null,
	bairro varchar(25) not null,
	cep varchar(9) not null,
	complemento varchar(20),
	observaçao varchar(20),
	id_pessoa int not null
);


create table cidade(
	id int not null auto_increment primary key,
	id_estado int not null,
	nome varchar(24) not null
);

create table estado(
	id int not null auto_increment primary key,
	nome varchar(20) not null,
	sigla varchar(2) not null
);
	
alter table cidade add constraint fk_cidade_estado foreign key (id_estado) references estado(id);
alter table endereco add constraint fk_endereco_cidade foreign key (id_cidade) references cidade(id);
alter table endereco add constraint fk_endereco_pessoa foreign key (id_pessoa) references pessoa(id);


create table produto(
	id int not null auto_increment,
	descricao varchar(100),
	id_fornecedor int,
	primary key(id)
);

select * from produto;
select * from fornecedor;

insert into produto (id_fornecedor) values (2);
insert into produto (descricao) values ('tenis');
insert into produto (descricao) values ('sapato');
insert into produto (descricao) values ('bota');
insert into produto (descricao) values ('sapato social');
insert into produto (descricao) values ('sapato social cpom bico fino');

insert into fornecedor (nome) values ('arezzo');
insert into fornecedor (nome) values ('mizuno');
insert into fornecedor (nome) values ('capodarte s/a');

alter table produto add constraint fk_produto_fornecedor foreign key (id_fornecedor) references fornecedor(id);

update produto set id_fornecedor = 1 where id = 2 or id = 5;
update produto set id_fornecedor = 2 where id = 6 ;
update produto set id_fornecedor = 3 where id in (1,3,4);-- para não fazer: id = 1 or id=3 or id=4 ;

alter table produto modify id_fornecedor int not null;
desc produto;
desc fornecedor;
desc venda;


alter table produto add column codigo_produto varchar(100);
alter table produto add column valor float(10,2);
alter table produto add column situacao varchar(1);

alter table fornecedor add column codigo_fornecedor varchar(100);
alter table fornecedor add column razao_social varchar(100);
alter table fornecedor add column telefone varchar(20);

select * from produto;

alter table produto add constraint fk_produto_fornecedor foreign key (id_fornecedor) references fornecedor(id);

alter table venda add constraint fk_venda_cliente foreign key (id_cliente) references cliente(id);
alter table venda add constraint fk_venda_fornecedor foreign key (id_fornecedor) references fornecedor(id);
alter table venda add constraint fk_venda_vendedor foreign key (id_vendedor) references vendedor(id);

alter table item_venda add constraint fk_item_venda_produto foreign key (id_produto) references produto(id);