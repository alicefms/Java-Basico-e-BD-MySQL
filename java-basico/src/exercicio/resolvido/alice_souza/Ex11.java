package exercicio.resolvido.alice_souza;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int count =0;

        int [][] matriz = new int [n][n];

        for (int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                matriz[i][j] = scan.nextInt();
            }
        }
        System.out.println("Elementos da Diagonal principal:");
        for (int i =0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i==j){
                    System.out.println(matriz[i][j] + " ");
                }
                if(matriz[i][j]<0){
                    count++;}
            }
        }
        System.out.println("Quantidade de elementos negativos: " +count);
    }
}
