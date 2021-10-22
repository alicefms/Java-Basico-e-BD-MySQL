PROCEDURE EXEMPLO DE ATUALIZACAO DE VALOR DE COMMISSAO POR VENDEDOR

delimiter $$
create  procedure atualizar_vl_comissao_por_vendedor(in vendedor int,
													in porcentagem double)
	begin
		
		if  (vendedor > 0 ) then
            update vendedor
            set n_porcvende =  porcentagem
            where id = vendedor ;
            
            commit;
        end if;

	end$$
delimiter ;



call atualizar_vl_comissao_por_vendedor(3, 12.4); 
