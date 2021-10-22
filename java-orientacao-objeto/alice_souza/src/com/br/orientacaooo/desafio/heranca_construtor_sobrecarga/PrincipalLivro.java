package com.br.orientacaooo.desafio.heranca_construtor_sobrecarga;

import java.util.Scanner;
/*Desafio de abstracao

 Implemente uma classe chamada MeuLivro que a herde e implemente o método abstrado dela.

    Entrada de dados
    Senhor dos Anéis


    Saída esperada
    Senhor dos Anéis
15 min para a solucao agora sao 10:40*/

public class PrincipalLivro {
    public static void main(String[] args) {
        Livro l1 = new MeuLivro();
        Scanner scan = new Scanner(System.in);
        String tit = scan.nextLine();
        l1.setTitulo(tit);
        scan.close();
        System.out.println(l1.getTitulo());
        l1.ler();
    }
}
