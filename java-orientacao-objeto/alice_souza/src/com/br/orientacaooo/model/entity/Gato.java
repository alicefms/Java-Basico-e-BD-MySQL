package com.br.orientacaooo.model.entity;

public class Gato extends Animal{
    public Gato(String nomeAnimal, String raca, String cor, int idadeMeses, String sexo){
        super(nomeAnimal, "gato", raca, cor, idadeMeses, sexo);
    }

    @Override
    public String emitirSom(){
        return (morto)? "Animal morto não emite som" :"miaaaaaaaaau";
    }

    @Override
    public String isAdulto() {
        if(morto)
            return "O animal morreu";
        else{

            return (idadeMeses > 24)? "É adulto": "É um filhotinho";}

    }


}
