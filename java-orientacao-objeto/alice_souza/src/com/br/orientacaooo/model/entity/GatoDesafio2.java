package com.br.orientacaooo.model.entity;

public class GatoDesafio2 extends AnimalDesafio{
    @Override
    public String getEspecie(){
        return getNome() + "é um Gato";
    }
}
