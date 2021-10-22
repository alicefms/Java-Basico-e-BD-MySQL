package com.br.orientacaooo.model.entity;

public class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome,int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public void showInfo() {
        System.out.println(nome);
        System.out.println(idade);
    }
}



