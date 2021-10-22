-- juncao de tabelas JOIN - inner join
select p.descricao, f.nome from produto p inner join fornecedor f on f.id = p.id_fornecedor; 

select codigo_produto as 'cod interno', descricao as 'produto', valor as 'preço', f.nome as 'fornecedor', f.telefone as 'contato forn' 
from produto p inner join fornecedor f on p.id_fornecedor =f.id ;

 -- fazer from de duas tabelas deixa o retorno lento. é melhor fazer o join.
-- é preferível usar o WHERE quando houver uma condição a ser avaliada...
select codigo_produto as 'cod interno', descricao as 'produto', valor as 'preço', f.nome as 'fornecedor', f.telefone as 'contato forn' 
from produto p , fornecedor f where p.id_fornecedor =f.id ;

select codigo_produto as 'cod interno', descricao as 'produto', valor as 'preço', f.nome as 'fornecedor', f.telefone as 'contato forn' 
from produto p , fornecedor f where p.id_fornecedor =f.id and p.id_fornecedor is not null;

-- evitar usar condições (where) com varchar, pefreir comparar ids
select codigo_produto as 'cod interno', descricao as 'produto', valor as 'preço', f.nome as 'fornecedor', f.telefone as 'contato forn' 
from produto p inner join fornecedor f on p.id_fornecedor =f.id 
where valor>1000 and f.id =4;

-- o uso do in
select * from cliente where id in(1,2);
select * from cliente where id<5;
select * from cliente where id not in(2,6);

-- subconsultas

select c.nome, c.data_cadastro from cliente c where id in (select id_cliente from venda v where id);
select c.nome, c.data_cadastro from cliente c where id not in (select id_cliente from venda v where id);

-- select dentro de select geram mais processamento...preferir usar o inner join quando couber...
select (select nome from cliente c where c.id = v.id_cliente) as 'Nome Cliente', v.* from venda v; 
select c.nome ,v.* from venda v inner join cliente c on c.id = v.id_cliente;

-- agrupamento de informações GROUP BY
-- apresentar a qte de vendas por cliente

select id_cliente, count(id) from venda group by id_cliente ;

select v.id_cliente, , c.nome from venda v inner join cliente c on c.id = v.id_cliente group by id_cliente ;

select c.id, c.nome ,count(codigo_venda) from venda v inner join cliente c on c.id = v.id_cliente 
group by c.id, v.id_cliente order by c.nome;

-- Saber quantas vezes um cliente comprou em um determindado fornecedor

select c.id, c.nome ,count(codigo_venda) from venda v inner join cliente c on c.id = v.id_cliente 
group by c.id, v.id_cliente order by c.nome;

select id_cliente , id_fornecedor from venda ;

select id_cliente , id_fornecedor from venda group by id_fornecedor, id_cliente ;

select id_cliente , id_fornecedor, count(id) from venda group by id_fornecedor, id_cliente order by 1;

select c.nome ,v.id_fornecedor , v.count(id) from venda v inner join cliente c group by v.id_fornecedor, v.id_cliente ;

select c.id, c.nome , id_fornecedor, count(codigo_venda) from venda v inner join cliente c on c.id = v.id_cliente 
group by v.id_cliente, v.id_cliente order by c.nome;


select c.id , c.nome, count(codigo_venda) 'qtde de compras', id_fornecedor 
from   venda v
inner join cliente c on c.id = v.id_cliente
group by   c.id, id_fornecedor 
order by   c.id;


select  c.id 'Código Interno', c.nome 'Cliente', 
        f.nome 'Fornecedor', count(codigo_venda) 'Qtde de compras por fornecedor'
from    venda v
inner join cliente c on c.id = v.id_cliente
inner join fornecedor f on f.id = v.id_fornecedor
group by   c.id, id_fornecedor 
order by   c.id;
