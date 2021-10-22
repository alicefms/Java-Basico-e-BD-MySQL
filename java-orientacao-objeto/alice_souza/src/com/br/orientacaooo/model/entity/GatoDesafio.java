package com.br.orientacaooo.model.entity;

public class GatoDesafio extends AnimalDesafio {
    public String nome;
   @Override
    public String getEspecie(){
       return nome + "é um gato";
   }

}
