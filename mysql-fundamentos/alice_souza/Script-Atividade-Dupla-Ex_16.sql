use atividade_dupla;

CREATE TABLE PAI(
    CODIGO int(18) NOT NULL PRIMARY KEY,
    NOME VARCHAR(255) NOT NULL
);

CREATE TABLE MAE(
    CODIGO int(18) NOT NULL PRIMARY KEY,
    NOME VARCHAR(255) NOT NULL
);

CREATE TABLE FILHO(
    CODIGO int(18) NOT NULL PRIMARY KEY,
    NOME VARCHAR(255) NOT NULL,
    PAI_CODIGO int(18),
    MAE_CODIGO int(18),
    FOREIGN KEY (PAI_CODIGO) REFERENCES PAI (CODIGO),
    FOREIGN KEY (MAE_CODIGO) REFERENCES MAE (CODIGO)
);

INSERT INTO MAE (CODIGO, NOME)
VALUES (1, 'Maria');

INSERT INTO MAE (CODIGO, NOME)
VALUES (2, 'Joana');

INSERT INTO MAE (CODIGO, NOME)
VALUES (3, 'Gabriela');

INSERT INTO MAE (CODIGO, NOME)
VALUES (4, 'Juliana');

INSERT INTO MAE (CODIGO, NOME)
VALUES (5, 'Marina');

-- -----------------------------------------------
INSERT INTO PAI (CODIGO, NOME)
VALUES (1, 'Alfredo');

INSERT INTO PAI (CODIGO, NOME)
VALUES (2, 'Joaquim');

INSERT INTO PAI (CODIGO, NOME)
VALUES (3, 'Juca');

INSERT INTO PAI (CODIGO, NOME)
VALUES (4, 'Juliano');

INSERT INTO PAI (CODIGO, NOME)
VALUES (5, 'Moacir');

-- ------------------------------------------------
INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (1, 'Zézinho', 2, 1);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (2, 'Tuca', null, 1);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (3, 'Jucelino', 3, 1);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (4, 'Marcelo', 4, 3);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (5, 'Chiquinha', 1, 4);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (6, 'Margarida', null, null);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (7, 'Rosa', 5, 5);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (8, 'Murilo', 1, 4);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (9, 'Rodrigo', 2, 2);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (10, 'Gustavo', 1, 2);

INSERT INTO FILHO (CODIGO, NOME, PAI_CODIGO, MAE_CODIGO)
VALUES (11, 'Leônidas', 3, 3);

COMMIT;

-- 15 de Setembro

select nome,
case 
	when (mae_codigo is not null)
	then 'Tem mãe'
	else 'Não tem mãe'
end as 'Mãe?',
case 
	when (pai_codigo is not null)
	then 'Tem pai'
	else 'Não tem pai'
end as 'Pai?'
from filho;

select f.nome,
	case 
		when m.nome is null then 'Não tem mãe'
		else m.NOME  
	end as 'Mãe'
from filho f
inner join mae m on f.MAE_CODIGO = m.codigo;


-- Mostrar os nomes dos filhos, nome da mãe e nome do pai. Trazer apenas filhos que tenham mãe. Se não possui pai, mostrar no lugar do nome da pai, não tem pai. 
select 	f.nome as 'Filho(a)', 
		case 
			when (p.nome is null)
			then 'Não tem pai'
			else p.nome			
		end as 'Pai', 
		m.nome as 'Mãe' 
from filho f
inner join pai p on f.PAI_CODIGO = p.CODIGO 
inner join mae m on f.MAE_CODIGO = m.CODIGO 
where (f.MAE_CODIGO is not null);

-- Mostrar a quantidade de filhos que não possuem mãe ou não possuem pai
select count(*) from filho f
where f.PAI_CODIGO is null 
or f.MAE_CODIGO is null;

-- Mostrar o nome do pai e a quantidade de filhos que o pai possui
select p.nome, count(PAI_CODIGO) as 'Qtd filho(s)' from filho f
inner join pai p on f.PAI_CODIGO = p.CODIGO 
where PAI_CODIGO is not null
group by p.nome;

-- Mostrar o nome do filho e nome da mãe, ordenando pelo nome da mãe
select f.nome as 'Filho(a)', m.nome as 'Mãe' from filho f
inner join mae m on m.codigo = f.MAE_CODIGO
order by m.NOME;

-- Mostrar o nome dos filhos que tenham a mãe como Gabriela, Juliana (utilizando OR)
select f.NOME as 'Filho(a)', m.NOME as 'Mãe' from filho f
inner join mae m on f.MAE_CODIGO = m.CODIGO
where (
	m.NOME = 'Gabriela' or
	m.NOME = 'Juliana'
);

-- Mostrar o nome dos filhos que não tenham o pai como Juca, Juliano (utilizando IN)
select f.nome as 'Filho(a)' from filho f 
inner join pai p on f.PAI_CODIGO = p.CODIGO
where p.nome not in ('Juca', 'Juliano');

-- Mostrar os nomes dos pais que possuem mais de 1 filho
select p.nome as 'Nome do pai'
from filho f
inner join pai p on f.PAI_CODIGO = p.CODIGO 
where f.PAI_CODIGO  is not null 
group by f.PAI_CODIGO
having count(f.PAI_CODIGO) > 1;

-- Mostrar os nomes dos pais e mãe que possuem mais de 1 filho
select p.nome as 'Nome do pai ou mãe'
from filho f
inner join pai p on f.PAI_CODIGO = p.CODIGO 
where f.PAI_CODIGO  is not null 
group by f.PAI_CODIGO
having count(f.PAI_CODIGO) > 1 
union
select m.nome 
from filho f
inner join mae m on f.mae_CODIGO = m.CODIGO 
where f.mae_CODIGO  is not null 
group by f.mae_CODIGO
having count(f.mae_CODIGO) > 1;

-- Mostrar o nome do pai e da mãe, mostrando a quantidade de filhos que tem juntos, ordenando a consulta para trazer os que possuem mais filhos juntos
select m.nome as 'Mãe', p.nome as 'Pai', count(*) as 'Qtd_de_Filhos'
from filho f
inner join mae m on m.codigo = f.mae_codigo
inner join pai p on p.codigo = f.pai_codigo
group by f.mae_codigo, f.pai_codigo
order by Qtd_de_Filhos desc;

-- Mostrar os nomes dos pais e mãe, e caso tenha um filho, mostrar “Tem um filho”, caso possua dois filhos mostrar “Tem um casal”, caso tem mais filhos “Eles não dormem”
select m.nome as 'Mãe', p.nome as 'Pai', 
case 
	when count(*) = 1 then 'Tem um filho'
	when count(*) = 2 then 'Tem um casal'
	when count(*) > 2 then 'Eles não dormem'
end as 'Mensagem'
from filho f
inner join mae m on f.mae_codigo = m.codigo
inner join pai p on f.pai_codigo = p.codigo
group by f.mae_codigo, f.pai_codigo;

-- Trazer a quantidade de filhos que não tem pai e nem mãe
select count(*) as 'Não tem pai nem mãe' from filho where MAE_CODIGO is null and PAI_CODIGO is null;

-- Trazer apenas as mães que não tenham filhos
select m.nome from mae m 
left join filho f on m.CODIGO = f.MAE_CODIGO 
where f.NOME is null;

-- Trazer os filhos e o nome do pai, dos filhos que possuem “ri” no nome, ordenando pelo nome do pai decrescente
select f.nome 'filho', p.nome 'pai' from filho f 
inner join pai p on  p.codigo = f.pai_codigo
where f.NOME like '%ri%' order by p.NOME desc;
 
-- Trazer os nomes dos pais, e outra coluna com a quantidade de caracteres que o nome do pai possui (Exemplo: SELECT LENGTH(‘Pedro’) FROM DUAL)
select nome as 'Nome do Pai', length(nome)  as 'Qte de caracteres' from pai;
