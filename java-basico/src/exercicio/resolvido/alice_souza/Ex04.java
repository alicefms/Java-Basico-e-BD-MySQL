package exercicio.resolvido.alice_souza;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int menorAB;
        if (A<B) {
            menorAB = A ;
        } else {
            menorAB = B;
        }
        if(menorAB<C){
            System.out.println(menorAB);
        } else System.out.println(C);

        scan.close();
    }
}
