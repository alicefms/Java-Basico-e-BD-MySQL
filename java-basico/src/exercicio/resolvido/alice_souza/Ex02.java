package exercicio.resolvido.alice_souza;

import java.util.Locale;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        float largura, comprimento, valor;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        largura = sc.nextFloat();
        comprimento = sc.nextFloat();
        valor = sc.nextFloat();

        System.out.printf("AREA = %.2f%n", largura*comprimento);
        System.out.printf("PRECO = %.2f", largura*comprimento*valor);

        sc.close();

    }
}
