package com.br.orientacaooo.estruturadados;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {
    public static void main(String[] args) {
        List<String> listaNomes = new ArrayList<>();

        listaNomes.add("Val");
        listaNomes.add("Samyra");
        listaNomes.add("Carol");
        listaNomes.add("Ana Rita");
        listaNomes.add("Ana Luisa");
        listaNomes.add("Luana");
        for (String nome: listaNomes){
            System.out.println(nome);
        }
        System.out.println("-----------");
        listaNomes.add(2,"Alline");  //empurra os outros itens pra frente
        listaNomes.set(2, "Alice");               //sobrescreve
        listaNomes.remove("Val");
        listaNomes.remove(0);

        for (String nome: listaNomes){
            System.out.println(nome);
        }

        System.out.println(" Índice de Alice => " + listaNomes.indexOf("Alice"));
        System.out.println("A lista contem "+ listaNomes.size()+ " elementos");
       // listaNomes.removeIf(x -> x.charAt(0) == 'A');

        for (String nome: listaNomes){
            System.out.println(nome);
        }

            // filtro
        List<String> resultadoFiltro = listaNomes.stream().filter(x ->x.charAt(0) == 'A').collect(Collectors.toList());
        System.out.println("Resultado do Filtro");

        for (String nome: resultadoFiltro){
            System.out.println(nome);
        }
    }
}
