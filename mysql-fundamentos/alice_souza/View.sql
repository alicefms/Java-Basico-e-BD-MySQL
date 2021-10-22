-- criação de view

create or replace view relatorio as 
select m.nome as 'Mãe', p.nome as 'Pai', f.nome 'filho'
from filho f
inner join mae m on m.codigo = f.mae_codigo
inner join pai p on p.codigo = f.pai_codigo
;