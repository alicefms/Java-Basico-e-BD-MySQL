package com.br.orientacaooo.desafio.heranca_construtor_sobrecarga;




public class MeuLivro extends Livro {
    private String titulo;
    private String autor;

    public MeuLivro(){}

    public void setAutor(String autor) {
        this.autor = autor;
    }
    //implementa -obrigatoriamente- o método abstrato assinado na superclasse
@Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public void ler() {
        super.ler();
    }
}
