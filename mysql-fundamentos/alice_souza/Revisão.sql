select * from produto p 

insert into produto(DESCRICAO_PRODUTO)
             VALUES('Feijao'),
             ('arroz'),
             ('carne de frango'),
             ('macarrao'),
             ('lentilha'),
            ('polvilho'); 

insert into produto(DESCRICAO_PRODUTO)
             VALUES('Feijao carioquinha'),
             ('Feijao branco'),
             ('Feijao marrom');


create table FORNECEDOR(
    CODIGO_FORNECEDOR INT not null auto_increment primary key,
    NOME_FORNECEDOR VARCHAR(100) not null,
    CNPJ VARCHAR(20)
);

-- um produto so pode TER UM E SOMENTE UM FORNECEDOR 

UM PARA MUITOS
FORNECEDOR        ---->     PRODUTO
        1                    N

insert into FORNECEDOR(NOME_FORNECEDOR)
            VALUES('mazer');


-- MUITOS PARA MUITOS 
-- muitos fornecedores fornecendo muitos produtos
-- muitos produtos sao fornecidos por varios
-- fornecedores
select * from PRODUTO;
select * from fornecedor_produto;
select * from FORNECEDOR;

-- um produto pode TER MAIS DE UM FORNECEDOR 
MUITOS PARA MUITOS

FORNECEDOR        ---->     PRODUTO
        N                    N



create table fornecedor_produto(
    codigo_fornecedor int not null,
    codigo_produto int not null
);


insert into produto(descricao_produto)
values('memoria corsair 16bg'),
('memoria kingston 16gb')

insert into fornecedor_produto(codigo_fornecedor, codigo_produto)
values (3,    10),
       (4,    10),
       (3,    11),
       (5,    12);
       
      
      
 -- EXERCICIOS
      
create table PRODUTO(
codigo_produto int not null auto_increment primary key,
descricao_produto varchar(100) default null,
preco_produto float (5,2) default null
);

create database data2;
use data2;

insert into FORNECEDOR(NOME_FORNECEDOR)
            VALUES('Fornecedor 1'), ('Ferreira Costa'), ('Armazém coral'), ('BomPreço'), ('Extra');
           
           
insert into produto(DESCRICAO_PRODUTO)
             VALUES('Placa mãe');
           
-- teste de select           
select f.nome_fornecedor, p.descricao_produto from fornecedor f
left join fornecedor_produto fp on f.codigo_fornecedor = fp.codigo_fornecedor
left join produto p on p.codigo_produto = fp.codigo_produto;
-- acrescimo

alter table produto add column c_fornecedor int not null;


update produto set c_fornecedor = 1 where codigo_produto in (1,3); 
update produto set c_fornecedor = 2 where codigo_produto in (2,4); 
update produto set c_fornecedor = 3 where codigo_produto in (3,5); 
update produto set c_fornecedor = 4 where codigo_produto in (6,11); 
update produto set c_fornecedor = 5 where codigo_produto in (7,9); 
update produto set c_fornecedor = 6 where codigo_produto in (8,10,12); 


alter table produto add constraint fk_produto_fornecedor foreign key (c_fornecedor) references fornecedor(codigo_fornecedor);

select p.descricao_produto, f.nome_fornecedor from produto p
inner join fornecedor f on p.c_fornecedor = f.codigo_fornecedor;