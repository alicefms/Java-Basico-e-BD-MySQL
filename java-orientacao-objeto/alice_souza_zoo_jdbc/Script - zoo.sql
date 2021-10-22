use zoo;
create table animal(
	id int not null auto_increment primary key,
	nome varchar (20),
	especie varchar (20),
	raca varchar (20),
	cor varchar (20),
	sexo varchar(1),
	morto boolean default false,
	dono int,
	data_nascimento datetime,
	data_cadastro datetime
	
);

create table pessoa(
	id int not null auto_increment primary key,
	nome varchar(20));

insert into pessoa(nome) values("Alice");
insert into pessoa(nome) values("Neto");
insert into pessoa(nome) values("Roberto");
insert into pessoa(nome) values("Esdras");

alter table animal add constraint fk_animal_dono foreign key (dono) references pessoa(id);

insert into animal(nome, especie, raca, cor, sexo, dono, data_nascimento, data_cadastro) values (
"rex", "cachorro","SRD", "branco",'M', 1, "2000-01-25", "2021-10-01" );

