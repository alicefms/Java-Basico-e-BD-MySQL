package server;

import dao.AnimalDAO;
import model.Animal;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

        AnimalDAO animalDAO = new AnimalDAO();
       Animal a = new Animal("Rorentinha 2", "cachorro","SRD", "marrom","M", 4, "2020-01-25", "2021-10-01");
       Animal b = new Animal("Rasta 2", "gato","SRD", "branco e mesclado","M", 1, "2021-01-25", "2021-10-01");
       Animal c = new Animal("Samba 2", "gato","SRD", "branco e preto","F", 3, "2020-09-25", "2021-10-01");

       // animalDAO.save(a);
      //System.out.println(animalDAO.findAll());
     //System.out.println(animalDAO.findById(13));

    //System.out.println(animalDAO.findByDono(4));
      //animalDAO.alteraDono(2, 4);
      //animalDAO.mudaNome(13, "Aurora");
        List<Animal> lista = new ArrayList<Animal>() {
        };
        lista.add(a);
        lista.add(b);
        lista.add(c);

       animalDAO.saveMore(lista);
      //System.out.println(animalDAO.CalculaIdade(1));
       //System.out.println(animalDAO.animalDono(5));

    }
}
