package com.br.orientacaooo.server;
import com.br.orientacaooo.model.entity.Animal;
import com.br.orientacaooo.model.entity.Cachorro;
import com.br.orientacaooo.model.entity.Gato;
import com.br.orientacaooo.model.entity.Girafa;

public class Principal {
    public static void main(String[] args) {
        // strings soltas
        String nomeAnimal = "Dara Anne";
        String especie = "felino";
        String raca = "SRD";
        String cor = "Tricolor";
        System.out.println("Seu animal é um "+especie+" de raça "+ raca+" e quanto a coloração é "+cor + " com nome " + nomeAnimal);

        // declarando instancia do objeto Animal
        Animal c = new Cachorro();

        //setando valores
        c.setNomeAnimal("Chico");
        c.setEspecie( "cachorro");
        c.setRaca("SRD");
        c.setCor("caramelo");
        System.out.println("MÉTODO TOSTRING DE OBJETOS GENERICOS DO TIPO ANIMAL:");
        System.out.println(c.toString());

        Animal g = new Girafa();
        g.setNomeAnimal("Gigi");
        g.setEspecie("girafa");
        g.setRaca("pincher");
        g.setCor("malhada");

        System.out.println(g.toString());
        System.out.println(g.emitirSom());



        //objeto especializado
        System.out.println("MÉTODO TOSTRING DE OBJETOS ESPECIALIZADOS CACHORRO E GIRAFA:");
        Animal g2 = new Girafa("Lolita", "Doberman", "bolinhas amarelas", 56, "femea");
        System.out.println(g2);

        Animal c2 = new Cachorro("Pedrita", "vira lata", "preta", 12, "macho");
        System.out.println(c2);
        System.out.println(g);
        System.out.println(g2.emitirSom());
        System.out.println(c2.emitirSom());

        Animal gg = new Gato("Alceu", "SRD", "Branco e preto", 10, "femea");
        System.out.println(gg);
        System.out.println(gg.emitirSom());
        System.out.println(gg.toString());

        System.out.println(gg.isAdulto());
        System.out.println(c2.isAdulto());
        System.out.println(g2.emitirSom());
        System.out.println(g2.isAdulto());
        System.out.println(g2.emitirSom());
        c2.morrer();
        g2.morrer();
        System.out.println(c2.isAdulto());
        System.out.println(g2.emitirSom());
        System.out.println(g2.isAdulto());
        System.out.println(g2.emitirSom());
    }
}
