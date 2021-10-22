package com.br.orientacaooo.exercicioResolvido;

public class Funcionario {
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void incrementarSalario(int id, double percentual){
        salario = getSalario() + getSalario()*percentual/100;
        System.out.println("O novo salário de "+ nome + " é " + salario);
    }
}
