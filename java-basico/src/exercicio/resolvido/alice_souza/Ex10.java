package exercicio.resolvido.alice_souza;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int y = scan.nextInt();

        int [][] matriz = new int [x][y];

        for (int i =0; i<x; i++){
            for(int j = 0; j<y; j++){
                matriz[i][j] = scan.nextInt();
            }
        }

        for (int i =0; i<x; i++){
            for(int j = 0; j<y; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        scan.close();

    }
}
