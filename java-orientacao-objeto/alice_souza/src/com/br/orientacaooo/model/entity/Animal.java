package com.br.orientacaooo.model.entity;

public abstract class Animal implements IAnimal{
    //declara propriedades do objeto
    // privacidade alterada para private (atributos encapsulados)

    protected String nomeAnimal;
    protected String especie;
    protected String raca;
    protected String cor;
    protected int idadeMeses;
    protected String sexo;
    protected boolean morto;

    public Animal(){
        System.out.println("Objeto Constrído");
    }
    public Animal(String nomeAnimal, String especie, String raca, String cor, int idadeMeses, String sexo){
        this.nomeAnimal = nomeAnimal;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.idadeMeses = idadeMeses;
        this.sexo = sexo;
    }

    //método acessor para receber os valores das propriedades

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setIdadeMeses(int idadeMeses) {
        this.idadeMeses = idadeMeses;
    }

    //método acessor para devolver os valores das propriedades


    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getCor() {
        return cor;
    }

    public int getIdadeMeses() {
        return idadeMeses;
    }

    public boolean isMorto() {
        return morto;
    }

    public void morrer() {
        this.morto = true;
    }

    @Override // sobrescrever o método da super classe
    public String toString() {
        return "Animal: Seu animal é um(a) " + this.especie +
                " de nome " + this.nomeAnimal +
                " da raça " + this.raca +
                " e quanto a coloração é " + this.cor
                ;
    }


}
