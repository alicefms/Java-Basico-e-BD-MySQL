package com.br.orientacaooo.server;

import com.br.orientacaooo.model.entity.AnimalDesafio;
import com.br.orientacaooo.model.entity.GatoDesafio2;

import java.util.Scanner;

public class PrincipalDesafio {
    public static void main(String[] args) {
        AnimalDesafio gatoD = new GatoDesafio2();
        Scanner scan = new Scanner(System.in);
        gatoD.setNome(scan.nextLine());
        scan.close();
        System.out.println(gatoD.getEspecie());

    }
}
