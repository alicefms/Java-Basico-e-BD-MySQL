package com.br.orientacaooo.desafio;

public class Paciente {
    private int codigo;
    private String nome;
    private String sobrenome;
    private int idade;
    private char sexo;
    private String telefone;
    private String endereco;

    public Paciente (int codigo, String nome, String sobrenome, int idade, char sexo, String telefone, String endereco){
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome =sobrenome;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void marcar(){}
    public void remarcar(){}
    public void consultar(){}
    public void cancelar(){}
}
