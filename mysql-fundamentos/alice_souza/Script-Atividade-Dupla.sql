-- Alice & Ambrósia
-- 14 de Setembro de 2021

create database atividade_dupla;

use atividade_dupla;

create table ALUNO (
	id int not null auto_increment primary key,
	nome varchar(30),
	data_nascimento date,
	sobrenome varchar(30),
	endereco varchar(30)
);

drop table ALUNO;

create table ALUNO (
	id int not null auto_increment primary key,
	nome varchar(30) not null,
	sobrenome varchar(30) not null,
	nome_pai varchar(30),
	nome_mae varchar(30),
	endereco varchar(30),
	numero_casa int,
	nome_cidade varchar(50),
	sigla_estado char(2)	
);


create table INSTITUICAO_ENSINO (
	id int not null auto_increment primary key,
	nome_instituicao varchar(40) not null,
	endereco varchar(40) not null,
	razao_social varchar(40) not null,
	telefone bigint not null,
	observacao varchar(50) not null	
);

alter table INSTITUICAO_ENSINO drop column observacao;

alter table INSTITUICAO_ENSINO add column nome_reitor varchar(30);
alter table INSTITUICAO_ENSINO add column nome_vice_reitor varchar(30);

alter table INSTITUICAO_ENSINO add column data_inauguracao timestamp not null;

alter table INSTITUICAO_ENSINO drop column nome_reitor;
alter table INSTITUICAO_ENSINO drop column nome_vice_reitor;

create table PROFESSOR (
	id int not null auto_increment primary key,
	nome varchar(30) not null,
	titularidade varchar(30) not null,
	endereco varchar(40) not null
);

alter table PROFESSOR drop column endereco;
alter table PROFESSOR add column cidade_residencia varchar(50) not null;
alter table PROFESSOR add column cidade_nascimento varchar(50) not null;
alter table PROFESSOR add column salario float not null;

alter table PROFESSOR modify column salario float(8, 2);

alter table INSTITUICAO_ENSINO rename to FACULDADE;

create table DEPARTAMENTO (
	id int not null auto_increment primary key,
	nome_departamento varchar(30) not null,
	nome_presidente varchar(30) not null,
	localizacao varchar(30) not null,
	orcamento_mensal float(9, 2)
);

alter table DEPARTAMENTO rename to CENTRO;

create table LIVRO(
	id int not null auto_increment primary key,
	nome_livro varchar(30) not null,
	ano_lancamento int,
	nome_autor varchar(30),
	qtd_paginas int
);

insert into LIVRO values(null, 'Dom Quixote', 1605, 'Miguel de Cervantes', 378);
insert into LIVRO values(null, 'Guerra e Paz', 1869, 'Liev Tolstói', 652);
insert into LIVRO values(null, 'A Montanha Mágica', 1924, 'Thomas Mann', 847);
insert into LIVRO values(null, 'Ulisses', 1922, 'James Joyce', 65);
insert into LIVRO values(null, 'Cem Anos de Solidão', 1967, 'Gabriel García Márquez', 987);
insert into LIVRO values(null, 'A Divina Comédia', 1321, 'Dante Alighieri', 587);
insert into LIVRO values(null, 'Em Busca do Tempo Perdido', 1913, 'Marcel Proust', 872);
insert into LIVRO values(null, 'O Som e a Fúria', 1929, 'William Faulkner', 254);

select * from LIVRO where ano_lancamento > 1900; -- Trazer apenas livros com data de lançamento maior que 1900
select * from LIVRO where ano_lancamento < 1605;
select * from LIVRO where ano_lancamento >= 1967;
select * from LIVRO where nome_autor = 'Liev Tolstói';
select * from LIVRO where nome_autor = 'James Joyce' or nome_autor = 'Marcel Proust';
-- select * from LIVRO where qtd_paginas >= 600 and qtd_paginas <= 1000;
select * from LIVRO where qtd_paginas between 600 and 1000;
select * from LIVRO where qtd_paginas > 367 or ano_lancamento = 1605;
select * from LIVRO where nome_livro = 'Ulisses' and qtd_paginas >= 65;
select nome_livro, ano_lancamento from LIVRO;
select nome_autor from LIVRO where qtd_paginas > 400;
select * from LIVRO where nome_livro like '%Anos%' or nome_autor like '%Liev%';
select * from LIVRO where nome_autor like '%w%';
select * from LIVRO where nome_livro like 'g%';
select concat('Nome: ', nome_livro, ', autor ', nome_autor, ' do ano ', ano_lancamento) from LIVRO; 
select nome_livro, (year(now()) - ano_lancamento) as 'Idade do livro com ano atual' ,(2000 - ano_lancamento) as 'Idade do livro com ano 2000' from LIVRO;
select concat('Nome ', nome_livro, ' - Ano de lançamento ', ano_lancamento) as 'Nome do livro - Ano de lançamento' from LIVRO where ((year(now()) - ano_lancamento) between 60 and 300);

insert into LIVRO values (null, 'Chapeuzinho vermelho', 1899, 'Miguel De Cervantes', 12);
insert into LIVRO values (null, 'Dona florinda', 1968, 'Miguel De Cervantes', 59);

select nome_livro, nome_autor, ano_lancamento from LIVRO order by nome_autor, ano_lancamento desc;

alter table LIVRO add column numero_volume int;
alter table LIVRO add column data_edicao datetime;

-- YYYY-MM-DD hh:mm:ss
update LIVRO set data_edicao = '2016-06-23' where nome_livro = 'Dom Quixote';
update LIVRO set data_edicao = '1989-02-28' where nome_livro = 'Guerra e Paz';
update LIVRO set data_edicao = '2015-02-01 14:25' where nome_livro = 'A Montanha Mágica';
update LIVRO set data_edicao = '1989-12-09' where nome_livro = 'Ulisses';
 -- NÃO INSERE POR CAUSA DA DATA ANTERIOR A 1970
update LIVRO set data_edicao = '1902-08-29' where nome_livro = 'Cem Anos de Solidão';
update LIVRO set data_edicao = '1806-09-28' where nome_livro = 'A Divina Comédia';

update LIVRO set data_edicao = '2005-09-08' where id in (7, 8 , 9, 10);

select nome_livro, nome_autor from LIVRO order by data_edicao desc;

select nome_livro, date_format(data_edicao , '%m/%y') as 'Data' from LIVRO;

select nome_livro from LIVRO where data_edicao >= '1989-01-01' 
and data_edicao >= '1989-12-31';



alter table LIVRO modify column nome_livro varchar(30) not null;
alter table LIVRO modify column nome_autor varchar(30) not null;

update LIVRO set data_edicao = '2005-09-08' where data_edicao is null;

alter table LIVRO modify column data_edicao datetime not null;

insert into LIVRO values (null, 'Cem Anos de Solidão', null, 'Gabriel García Márquez', null, null, null); -- Column 'data_edicao' cannot be null

insert into LIVRO values (null, 'Cem Anos de Solidão', null, 'Gabriel García Márquez', null, null, '1879-06-03');

select nome_livro, date_format(data_edicao, '%Y') as 'Ano de Edição' from LIVRO order by data_edicao desc;

select * from LIVRO;

-- 15 de Setembro de 2021

insert into LIVRO values (null, 'A volta dos que não foram', null, 'Liev Tolstói', null, null, '1789-01-01');
insert into LIVRO values (null, 'Poeira em alto mar', null, 'Thomas Mann', null, null, '1809-01-01');
insert into LIVRO values (null, 'Grande visões de um cego', null, 'James Joyce', null, null, '1968-01-01');
insert into LIVRO values (null, 'Lucidez de um louco', null, 'Gabriel García Márquez', null, null, '1709-01-01');

select nome_livro, data_edicao from livro where ano_lancamento is null; 

update livro set ano_lancamento = year(data_edicao) where ano_lancamento is null;

update livro set qtd_paginas = 100 where qtd_paginas is null;

select count(distinct nome_autor)'Qte de autores diferentes' from livro;

select count(nome_livro) from livro where nome_livro like '%a%';

select sum(qtd_paginas) 'Soma de Páginas' from livro where data_edicao >'2005-01-01';

alter table livro add column valor float(6,2);

update livro set valor = 35.99 where nome_autor = 'Miguel De Cervantes' or nome_autor = 'Liev Tolstói' or nome_autor ='Thomas Mann';

update livro set valor = 12.89 where nome_livro = 'Em Busca do Templo Perdido' or nome_livro = 'O Som e a Fúria' or nome_livro ='Chapeuzinho vermelho' or nome_livro ='Dona florinda';

update livro  set valor = 19.70 where valor is null and data_edicao < '2006-01-01';

update livro  set valor = 9.99 where valor is null;

-- Volta do recreio

select avg(valor) as 'media_de_precos' from livro;

SELECT 	nome_livro , 
	CASE 
		WHEN data_edicao < '2005-01-01' 
		THEN 'O livro é de no máximo 2 anos' 
		ELSE 'O livro é mais velho que dois anos' 
	END as 'Tempo do livro' 
FROM livro;

select count(numero_volume) from livro;

select monthname(data_edicao) as 'Mês da edição', count(*) as 'Quantidade' from livro group by month(data_edicao);

select nome_livro,
	case 
		when (
			nome_livro like '%a%' or 
			nome_livro like '%e%' or 
			nome_livro like '%i%' or 
			nome_livro like '%o%' or 
			nome_livro like '%u%'
		)
		then 'Possui vogal no nome'
		else 'Não possui vogal no nome'
	end as 'Vogal?'
from livro;

select avg(valor) as 'Média dos valores',
	case 
		when (
			nome_livro like '%a%' or 
			nome_livro like '%e%' or 
			nome_livro like '%i%' or 
			nome_livro like '%o%' or 
			nome_livro like '%u%'
		)
		then 'Possui vogal no nome'
		else 'Não possui vogal no nome'
	end as 'Vogal?'
from livro;


