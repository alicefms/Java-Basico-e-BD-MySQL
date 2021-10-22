package exercicio.resolvido.alice_souza;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tamanhoVetor = scan.nextInt();
        int [] listaNumeros = new int [tamanhoVetor];

        for (int i=0; i<tamanhoVetor; i++){
            listaNumeros[i] = scan.nextInt();
        }

        for(int i=0; i<tamanhoVetor; i++){
            if(listaNumeros[i]<0) {
                System.out.println(listaNumeros[i]);
            }
        }
        scan.close();
    }
}
