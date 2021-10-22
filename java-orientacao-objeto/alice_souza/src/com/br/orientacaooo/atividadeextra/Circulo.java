package com.br.orientacaooo.atividadeextra;

public class Circulo implements Forma{
    private double raio;

    public Circulo(){}
    public Circulo(double raio){
        this.raio = raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double area(){
        System.out.println("Implementei: Forma");
        return Math.pow(this.raio, 2)*Math.PI;
    }
}
