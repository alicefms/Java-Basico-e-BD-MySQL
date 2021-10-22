package com.br.orientacaooo.server;

import com.br.orientacaooo.model.dao.FornecedorDAO;
import com.br.orientacaooo.model.entity.Fornecedor;

import java.sql.SQLException;

public class CadastroFornecedores {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      //  Fornecedor f = new Fornecedor("teste modificar", "555555555");
        //f.setCodigoFornecedor(10);

        FornecedorDAO fDAO = new FornecedorDAO();
      //  fDAO.save(f);

      //  System.out.println(fDAO.findAll());
      // fDAO.delete(12);
       // fDAO.merge(f);
        System.out.println(fDAO.findById(4));



    }
}
