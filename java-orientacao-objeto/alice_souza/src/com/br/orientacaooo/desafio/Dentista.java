package com.br.orientacaooo.desafio;

public class Dentista {
    private String nome;
    private String sobrenome;
    private String especialidade;
    private int registroCro;
    private boolean ativo;

    public Dentista(String nome, String sobrenome, String especialidade, int registroCro, boolean ativo){
        this.nome = nome;
        this.sobrenome =sobrenome;
        this.especialidade = especialidade;
        this.registroCro = registroCro;
        this.ativo = ativo;
    }

    public void atender(){}
    public void marcar(){}
    public void remarcar(){}
    public void cancelar(){}
    public String relatar_indisponivel(){
        return "Não estarei diponível, pois irei a um congresso nesta data.";
    }

}
