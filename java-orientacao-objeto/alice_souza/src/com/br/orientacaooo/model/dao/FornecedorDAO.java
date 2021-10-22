package com.br.orientacaooo.model.dao;

import com.br.orientacaooo.infra.ConexaoMysql;
import com.br.orientacaooo.model.entity.Fornecedor;
import com.br.orientacaooo.model.entity.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements DAOGenerico<Fornecedor> {

    ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();
    private ConexaoMysql conexao;

    public FornecedorDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysql();
    }
    String query = "";
    @Override
    public void save(Fornecedor fornecedor) throws SQLException {
        query = "insert into fornecedor (nome_fornecedor, cnpj) values (?, ?)";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setString(2, fornecedor.getCNPJ());

            stmt.execute();
            this.conexao.commit();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    @Override
    public List<Fornecedor> findAll() throws SQLException {
        query = "select nome_fornecedor, cnpj from fornecedor";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            List<Fornecedor> listaPesquisada = new ArrayList<>();
            while (resultSet.next()){
                Fornecedor f = new Fornecedor(resultSet.getString("nome_fornecedor"),
                        resultSet.getString("CNPJ"));
                listaPesquisada.add(f);
            }
            return listaPesquisada;
        }catch (SQLException e){
            throw e;
        }
    }

    @Override
    public Fornecedor findById(int id) throws SQLException {
        query = "select nome_fornecedor, cnpj from fornecedor where codigo_fornecedor = ?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Fornecedor f = null;
            if (resultSet.next()) {
                f = new Fornecedor(id, resultSet.getString("nome_fornecedor"),
                        resultSet.getString("CNPJ"));}
                return f;
            }catch(SQLException e){
                throw e;
            }
        }




    @Override
    public void delete(int codigoFornecedor) throws SQLException {
        query = "delete from fornecedor where codigo_fornecedor=?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, codigoFornecedor);
            stmt.execute();
            this.conexao.commit();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    @Override
    public void merge(Fornecedor f) throws SQLException {
        query = "update fornecedor set nome_fornecedor= ?, cnpj= ?  where codigo_fornecedor = ? ";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, f.getNomeFornecedor());
            stmt.setString(2, f.getCNPJ());
            stmt.setInt(3, f.getCodigoFornecedor());

            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }


}
