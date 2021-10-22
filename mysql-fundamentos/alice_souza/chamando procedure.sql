-- alterando tabela pra add coluna
use loja;

alter table venda add column vl_comissao float(10,2);
alter table venda add column valor_total_comissao float(10,2);

-- chamar procedure

call gerar_comissao('2015-01-01','2015-05-30' ,@a);
select @a;