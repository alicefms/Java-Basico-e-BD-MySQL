package exercicio.resolvido.alice_souza;

import java.util.Locale;
import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        int tamanhoVetor = scan.nextInt();

        double[] vetorReal = new double[tamanhoVetor];
        double soma = 0.0;
        for(int i = 0; i<tamanhoVetor; i++){
            vetorReal[i] = scan.nextInt();
        }
        for(int i = 0; i<tamanhoVetor; i++){
            System.out.print(vetorReal[i] + " ");
            soma += vetorReal[i];
        }
        double media = soma/tamanhoVetor;
        System.out.println();
        System.out.printf("Media : %.1f", media);

        scan.close();
    }
}
