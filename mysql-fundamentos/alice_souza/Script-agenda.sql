create database agenda_contatos;
use agenda_contatos;

create table pessoa(
    id int not null auto_increment primary key,
    nome varchar(10) not null,
    sobrenome varchar(20) not null,
    data_de_nascimento date not null,
    data_de_cadastro date not null
);
create table email(
    id int not null auto_increment primary key,
    id_pessoa int not null,
    email varchar(50) not null
);
create table telefone(
    id int not null auto_increment primary key,
    id_pessoa int not null,
    telefone varchar(15) not null,
    tipo varchar(7) not null
);
create table formacao(
    id int not null auto_increment primary key,
    id_pessoa int not null,
    instituicao_ensino varchar(60) not null,
    grau varchar(60) not null,
    ano_conclusao int not null
);

alter table formacao add constraint fk_formacao_pessoa foreign key (id_pessoa) references pessoa(id);
alter table email add constraint fk_email_pessoa foreign key (id_pessoa) references pessoa(id);
alter table telefone add constraint fk_telefone_pessoa foreign key (id_pessoa) references pessoa(id);

alter table pessoa add column sexo varchar(1) not null after sobrenome;
alter table formacao add column curso varchar(30) not null after instituicao_ensino;
alter table endereco add column id_cidade int not null after id_pessoa;


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

insert into estado (nome, sigla) values ('São Paulo', 'SP');
insert into estado (nome, sigla) values ('Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values ('Alagoas', 'AL');
insert into estado (nome, sigla) values ('Mato Grosso do Sul', 'MS');
insert into estado (nome, sigla) values ('Amazonas', 'AM');
insert into estado (nome, sigla) values ('Pernambuco', 'PE');
insert into estado (nome, sigla) values ('Goiás', 'GO');
insert into estado (nome, sigla) values ('Paraíba', 'PB');

insert into cidade (id_estado, nome) values (1,'São José dos Campos');
insert into cidade (id_estado, nome) values (2,'Belford Roxo');
insert into cidade (id_estado, nome) values (1,'Hortolândia');
insert into cidade (id_estado, nome) values (3,'Maceió');
insert into cidade (id_estado, nome) values (4,'Campo Grande');
insert into cidade (id_estado, nome) values (5,'Manaus');
insert into cidade (id_estado, nome) values (6,'Recife');
insert into cidade (id_estado, nome) values (7,'Iporá');
insert into cidade (id_estado, nome) values (8,'Rio Tinto');

insert into pessoa values(null,'Camila','Oliveira','F','2001-09-09','2021-09-09');
insert into formacao values(null,1,'ITA','Engenharia da Computação','Superior',2023);
insert into email values(null,1,'camilaoliveira@email.com');
insert into telefone values(null,1,'(12) 5482-4287','Fixo');
insert into telefone values(null,1,'(12) 99883-8715','Celular');
insert into endereco values(null,'Rua 123','34-A','Bairro do Sossego','45545-455',null,'Apartamento',1,1);

insert into pessoa values(null,'Mariana','Belém','F','1990-09-09','2021-09-09');
insert into formacao values(null,3,'UFPE','Engenharia da Computação','Superior',2023);
insert into email values(null,3,'mari@email.com');
insert into telefone values(null,3,'(81) 5555-4287','Fixo');
insert into telefone values(null,3,'(12) 99999-8715','Celular');
insert into endereco values (null, 'Rua do Machado', '125', 'Arruda', '52481-525', null, null, 3, 6 );

select * from pessoa;
select * from endereco;
select * from formacao;
select * from cidade;
select * from estado;
desc endereco;

select*from pessoa,endereco,cidade,estado,formacao;

select * from pessoa;

select pessoa.nome,pessoa.sobrenome,pessoa.sexo,pessoa.data_de_nascimento,pessoa.data_de_nascimento,email.email,endereco.logradouro,endereco.numero ,endereco.bairro ,cidade.nome cidade,estado.nome estado,formacao.curso Curso,formacao.grau Grau, formacao.instituicao_ensino Instituicao from pessoa,endereco,email,cidade,estado,formacao where pessoa.id=email.id_pessoa and pessoa.id =endereco.id_pessoa and endereco.id_cidade=cidade.id and cidade.id_estado =estado.id and formacao.id_pessoa =pessoa.id;



