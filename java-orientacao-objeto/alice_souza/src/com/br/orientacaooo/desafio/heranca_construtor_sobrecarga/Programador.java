package com.br.orientacaooo.desafio.heranca_construtor_sobrecarga;

import com.br.orientacaooo.model.entity.Pessoa;

public class Programador extends Pessoa {
    private String nome;
    private int idade;
    private String linguagem;

    public Programador(String nome, int idade, String linguagem){
        super(nome, idade);
        this.nome = nome;
        this.idade = idade;
        this.linguagem = linguagem;
    }

    @Override
    public void showInfo(){
        super.showInfo();
        System.out.println(linguagem);

    }
}
