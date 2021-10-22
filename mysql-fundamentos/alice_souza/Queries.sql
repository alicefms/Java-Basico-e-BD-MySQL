-- retornar a sequencia
select auto_increment from information_schema.tables where table_name = 'venda' and table_schema = 'loja';
-- retorna 21, que vai ser o id da proxima venda, auntoincrementado.

-- full scan
select * from produto;

-- consulta alguns campos
select descricao, codigo_produto, valor from produto;

-- ordenacao da instrucao |query | o padrao é ascendente, para alterar : desc
select descricao, codigo_produto, valor from produto order by descricao;
select descricao, codigo_produto, valor from produto order by codigo_produto desc;

-- ordena usando ordem da coluna
select * from produto order by 2;
select descricao, valor from produto order by 1 desc;

-- query com where
select descricao, valor from produto where id<4;

-- query com like -em qualquer lugar da string: %xyz%
select descricao, valor from produto where descricao like '%art%';

-- query com like -que começa com : 'xyz%'
select descricao, valor from produto where descricao like 'sm%';

-- query com like -que termina com : '%xyz'
select descricao, valor from produto where descricao like '%one';

-- contar total de linhas da tabela
select count(id) from item_venda;
select count(*) from item_venda;

-- alias nas colunas
select count(*) as 'Total de linhas na tabela' from item_venda;
select id as 'Código do produto',
		descricao as 'Descição',
		valor as 'Valor' from produto;

-- format e concat
select id, descricao, concat ("R$", format (valor,2)) as 'Valor' from produto;

-- max e min
select max(valor) from produto;
select min(descricao) from produto; -- se colocar varchar, ele pega a ordem alfabetica.

-- função sum
select sum(valor) from produto;

-- somar duas colunas
select max(valor) + min(valor) from produto;

select descricao , valor from produto where valor=(select max(valor) from produto);

-- juncao de tabelas JOIN
select p.descricao, f.nome from produto p inner join fornecedor f on f.id = p.id_fornecedor; 



