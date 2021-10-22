package exercicio.resolvido.alice_souza;

import java.util.Locale;
import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        double somaAltura =0;
        int menorde16 =0;

        for(int i = 0; i<N; i++){
            String nome = scan.next();
            int idade = scan.nextInt();
            double altura = scan.nextDouble();
            somaAltura += altura;
            if(idade<16){
                menorde16 +=1;
            }

        }
        System.out.printf("Altura média: %.1f%n", (somaAltura/N));
        System.out.printf("Porcentagem de pessoas com menos de 16 anos: %.1f%%", ((double)menorde16*100)/N) ;

    }
}
