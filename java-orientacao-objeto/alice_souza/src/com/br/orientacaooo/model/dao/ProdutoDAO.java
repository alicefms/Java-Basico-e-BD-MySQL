package com.br.orientacaooo.model.dao;

import com.br.orientacaooo.infra.ConexaoMysql;
import com.br.orientacaooo.model.entity.Fornecedor;
import com.br.orientacaooo.model.entity.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements DAOGenerico<Produto>{
    /*
                **DAO* / Data Access Object / Objeto de Acesso a Dados

    CONTÉM AS OPERAÇÕES DO CRUD PARA A TABELA DE PRODUTO
    * CRUD (Create, Read, Updade, Delete)
     - BANCO DE DADOS (Insert, Select, Update, Delete)
     - JAVA (Save, Find, Merge, Delete)

    ArrayList > aloca posições dinamicamente(não preciso dizer o tamanho), guarda tipos complexos(objetos).
*/
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    private ConexaoMysql conexao;

    public ProdutoDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysql();
    }
    String query = "";
    // CREATE

    public void save(Produto produto) throws SQLException {
      //  this.listaProdutos.add(produto);

        query = "insert into produto(descricao_produto, preco_produto, c_fornecedor) values (?,?, ?)";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, produto.getDescricaoProduto());
            stmt.setDouble(2, produto.getPrecoProduto());
            stmt.setInt(3, produto.getCodigoFornecedor());

            stmt.execute();
            this.conexao.commit();

        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    //READ




    @Override
    public List<Produto> findAll() throws SQLException {
    query = "select descricao_produto, preco_produto, c_fornecedor from produto";
    try{
        PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        List<Produto> listaPesquisada = new ArrayList<>();
        while (resultSet.next()){
            Produto p = new Produto(resultSet.getString("descricao_produto"),
                    resultSet.getDouble("preco_produto"), resultSet.getInt("c_fornecedor"));
            listaPesquisada.add(p);
        }
        return listaPesquisada;
    }catch (SQLException e){
        throw e;
    }
}

    @Override
    public Produto findById(int id) throws SQLException {
        query = "select descricao_produto, preco_produto, c_fornecedor from produto where codigo_produto = ?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Produto p = null;
            if (resultSet.next()) {
                p = new Produto(id, resultSet.getString("descricao_produto"),
                        resultSet.getDouble("preco_produto"), resultSet.getInt("c_fornecedor"));
            }
                return p;
        }catch(SQLException e){
            throw e;
        }
    }


    @Override
    public void delete(int codigoProduto) throws SQLException {
        query = "delete from produto where codigo_produto=?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, codigoProduto);
            stmt.execute();
            this.conexao.commit();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    @Override
    public void merge(Produto p) throws SQLException {
        query = "update produto set descricao_produto= ?, preco_produto= ?, c_fornecedor = ?  where codigo_produto = ? ";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, p.getDescricaoProduto());
            stmt.setDouble(2, p.getPrecoProduto());
            stmt.setInt(3, p.getCodigoFornecedor());
            stmt.setInt(4, p.getCodigoProduto());

            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }










    //método de Byanca
    public ArrayList<Produto> findAll2() {
        return listaProdutos;
    }

    // busca de 1 elemento pelo código do produto

    public void find(int codigo) {
        for (Produto p : listaProdutos) {
            if (p.getCodigoProduto() == codigo) {
                System.out.print(p.getCodigoProduto() + " ");
                System.out.print(p.getDescricaoProduto() + " ");
                System.out.print(p.getPrecoProduto());
            }
        }
    }

    public Produto findOne(int codigo) {
        for (Produto p : listaProdutos) {
            if (p.getCodigoProduto() == codigo) {
                return p;
            }
        } return null;
    }

    // UPDATE
    public void modify(int codigo) {
        for (Produto p : listaProdutos) {
            if (p.getCodigoProduto() == codigo) {
                p.setDescricaoProduto("ALTERAÇÃO");
                p.setPrecoProduto(null);
            }
        }

    }

    public void alter(int codigo, String descricao, Double preco) {
        for (Produto p : listaProdutos) {
            if (p.getCodigoProduto() == codigo) {
                p.setDescricaoProduto(descricao);
                p.setPrecoProduto(preco);
            }
        }

    }

    /* DELETE

    public void delete(int codigo) {
        for (int i = 0; i < listaProdutos.size(); i++) {                                    //usando for
            if (listaProdutos.get(i).getCodigoProduto() == codigo) {
                int indexExcluir = listaProdutos.indexOf(listaProdutos.get(i));
                listaProdutos.remove(indexExcluir);
            }
        }
    }*/

    public void delete2(int codigo) {
        for (Produto p : listaProdutos) {                                               //usando forEach
            if (p.getCodigoProduto() == codigo) {
                this.listaProdutos.remove(p);
                break;
            }

        }
    }


}