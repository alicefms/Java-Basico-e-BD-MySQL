package dao;

import infra.ConexaoMysql;
import model.Animal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalDAO {
    private ConexaoMysql conexao;
    String query = "";

    public AnimalDAO() throws SQLException, ClassNotFoundException {
        conexao = new ConexaoMysql();
    }

//cadastra um novo animal no banco
    public void save(Animal animal) throws SQLException {
        query = "insert into animal(nome, especie, raca, cor, sexo, dono, data_nascimento, data_cadastro) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, animal.getNomeAnimal());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getCor());
            stmt.setString(5, animal.getSexo());
            stmt.setInt(6, animal.getDono());
            stmt.setString(7, animal.getDataNascimento());
            stmt.setString(8, animal.getDataCadastro());

            stmt.execute();
            this.conexao.commit();
            this.conexao.close();


        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

 //Consulta todos os animais cadastrados
    public List<Animal> findAll() throws SQLException {
        query = "select nome, especie, raca, cor, sexo, dono, data_nascimento, data_cadastro from animal";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            List<Animal> listaPesquisada = new ArrayList<>();
            while (resultSet.next()) {
                Animal animal = new Animal(
                        resultSet.getString("nome"),
                        resultSet.getString("especie"),
                        resultSet.getString("raca"),
                        resultSet.getString("cor"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("dono"),
                        resultSet.getString("data_nascimento"),
                        resultSet.getString("data_cadastro"));

                listaPesquisada.add(animal);
            }
            return listaPesquisada;
        } catch (SQLException e) {
            throw e;
        }
    }

//visualizar as informações de um animal apresentando o seu respectivo dono
    public Animal findById(int id) throws SQLException {
        query = "select nome, especie, raca, cor, sexo, dono, data_nascimento, data_cadastro from animal where id=?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            Animal animal = null;
            if (resultSet.next()) {
                animal = new Animal(
                        resultSet.getString("nome"),
                        resultSet.getString("especie"),
                        resultSet.getString("raca"),
                        resultSet.getString("cor"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("dono"),
                        resultSet.getString("data_nascimento"),
                        resultSet.getString("data_cadastro"));
            }
            return animal;
        } catch (SQLException e) {
            throw e;
        }


    }

 // busca animal pelo dono
    public List<Animal> findByDono(int dono) throws SQLException {
        query = "select nome, especie, raca, cor, sexo, dono, data_nascimento, data_cadastro from animal where dono=?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, dono);
            ResultSet resultSet = stmt.executeQuery();
            List<Animal> listaPesquisada = new ArrayList<>();
            while (resultSet.next()) {
                Animal animal = new Animal(
                        resultSet.getString("nome"),
                        resultSet.getString("especie"),
                        resultSet.getString("raca"),
                        resultSet.getString("cor"),
                        resultSet.getString("sexo"),
                        resultSet.getInt("dono"),
                        resultSet.getString("data_nascimento"),
                        resultSet.getString("data_cadastro"));

                listaPesquisada.add(animal);
            }
            return listaPesquisada;
        } catch (SQLException e) {
            throw e;
        }
    }

 // Altera e/ou adiciona dono
    public void alteraDono(int id, int dono) throws SQLException {
        query = "update animal set dono =? where id=?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, dono);
            stmt.setInt(2, id);
            stmt.execute();
            this.conexao.commit();
            this.conexao.close();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

 //muda nome de animal
    public void mudaNome(int id, String nome) throws SQLException {
        query = "update animal set nome =? where id=?";
        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.execute();
            this.conexao.commit();
            this.conexao.close();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

//Salva mais de uma animal por vez
    public void saveMore(List<Animal> animais) throws SQLException {
        query = "insert into animal(nome, especie, raca, cor, sexo, dono, data_nascimento, data_cadastro) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);

        for (Animal animal : animais
        ) {

                stmt.setString(1, animal.getNomeAnimal());
                stmt.setString(2, animal.getEspecie());
                stmt.setString(3, animal.getRaca());
                stmt.setString(4, animal.getCor());
                stmt.setString(5, animal.getSexo());
                stmt.setInt(6, animal.getDono());
                stmt.setString(7, animal.getDataNascimento());
                stmt.setString(8, animal.getDataCadastro());

                stmt.execute();
            this.conexao.commit();

            }

            this.conexao.close();
        }
        catch (SQLException e) {
                this.conexao.rollback();
                throw e;
            }
        }
//busca animal pelo id e calcula sua idade
        public String CalculaIdade(int id) throws SQLException, ParseException {
        Animal animal =  findById(id);

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date cadastro = formato.parse(animal.getDataCadastro());
            Date nascimento = formato.parse(animal.getDataNascimento());

            long idade= Duration.between(nascimento.toInstant(), cadastro.toInstant()).toDays();
            return  "o animal "+ animal.getNomeAnimal() + " tem idade de " + idade/30 + " meses.";
        }

// retorna animal com nome do dono
    public String animalDono (int id) throws SQLException {
        Animal animal = findById(id);
        query = "select nome from pessoa where id=?";
        String nomeDono = "";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, animal.getDono());
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                nomeDono = resultSet.getString("nome");
            }

        }catch(SQLException e){
            throw e;
        }



        return "o animal: " + animal + "pertence a " + nomeDono;
    }

    }
