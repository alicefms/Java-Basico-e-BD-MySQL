package com.br.orientacaooo.model.entity;

public class Cachorro extends Animal {
    public Cachorro(String nomeAnimal, String raca, String cor, int idadeMeses, String sexo){
        super(nomeAnimal, "cachorro", raca, cor, idadeMeses, sexo);
    }
    public Cachorro(){}

    @Override
    public String emitirSom(){
        return (morto)? "Animal morto não emite som" : "au au ";
    }
    @Override
    public String isAdulto() {
                if(morto)
                    return "O animal morreu";
                else{

                    return (idadeMeses > 24)? "É adulto": "É um filhotinho";}
    }

}
