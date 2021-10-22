package com.br.orientacaooo.server;

import com.br.orientacaooo.desafio.heranca_construtor_sobrecarga.Programador;
import com.br.orientacaooo.model.entity.Pessoa;

import java.util.Scanner;

public class Gentes {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Carlos Silva", 33);

        System.out.println("nome");
        System.out.println("idade");
        System.out.println(p1.getNome());
        System.out.println(p1.getIdade());

        Pessoa p2 = new Programador("Alice", 65, "Java");
        System.out.println(p2.toString());

        //Captando dados com Scanner
        System.out.println("----------");
        Scanner scan = new Scanner(System.in);
        System.out.println("digite o nome");
        String nome = scan.nextLine();

        System.out.println("digite a idade");
        int idade = scan.nextInt();
        scan.nextLine();
        System.out.println("digite a linguagem");
        String linguagem = scan.nextLine();
        Pessoa a = new Programador(nome, idade, linguagem);
       a.showInfo();



    }
}
