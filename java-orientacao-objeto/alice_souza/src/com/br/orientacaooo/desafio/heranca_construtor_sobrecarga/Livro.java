package com.br.orientacaooo.desafio.heranca_construtor_sobrecarga;

public abstract class Livro {
    protected String titulo;
    protected String autor;

    public Livro (){}
// assinatura do método abstrato
    public abstract void setTitulo(String titulo);


    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void ler(){}
}
