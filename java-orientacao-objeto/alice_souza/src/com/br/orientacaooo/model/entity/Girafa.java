package com.br.orientacaooo.model.entity;
// Herança.
public class Girafa extends Animal{
    public Girafa(String nomeAnimal, String raca, String cor, int idadeMeses, String sexo){
        super(nomeAnimal, "girafa", raca, cor, idadeMeses, sexo);
    }

    public Girafa(){}

    @Override
    public String toString(){
        return "toString da girafa " + getRaca();
    }
    @Override
    public String emitirSom(){
        return (morto)? "Animal morto não emite som" : "fiu fiu";}


    @Override
    public String isAdulto() {
        if (morto)
            return "o animal morreu";
        else {
            if (this.sexo == "femea")
                return (idadeMeses >= 48) ? "É adulto" : "É um filhotinho";
            else
                return (idadeMeses >= 60) ? "É adulto" : "É um filhotinho";
        }
    }
}

