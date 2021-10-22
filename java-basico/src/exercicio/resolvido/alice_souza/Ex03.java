package exercicio.resolvido.alice_souza;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota1 = sc.nextDouble();
        double nota2 = sc.nextDouble();
        double media = (nota1 + nota2)/2;

        if(media<6) {
            System.out.println("REPROVADO");
        }else{
            System.out.println("APROVADO");
        }
        sc.close();

    }
}
