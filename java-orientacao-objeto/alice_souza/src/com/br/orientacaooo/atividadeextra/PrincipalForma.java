package com.br.orientacaooo.atividadeextra;

import java.util.Scanner;

public class PrincipalForma {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o raio");
      //  float raio1 = scan.nextFloat();
        //c1.setRaio(raio1);
        Forma c1 = new Circulo(scan.nextFloat());
        scan.close();
        System.out.printf("%.2f", c1.area());
    }
}
