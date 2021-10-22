package exercicio.resolvido.alice_souza;

import java.util.Scanner;

public class Ex05 {
    /*
     Faça um programa para ler um número indeterminado de dados, contendo cada um, a
     idade de um indivíduo. O último dado, que não entrará nos cálculos, contém um valor
     de idade negativa. Calcular e imprimir a idade média deste grupo de indivíduos. Se for
     entrado um valor negativo na primeira vez, mostrar a mensagem "impossivel calcular".
      */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int idade = scanner.nextInt();
        int contadorDeRepeticao = 0;
        int somaIdade = 0;

        while (idade >= 0) {
            contadorDeRepeticao++;
            somaIdade = somaIdade + idade;
            System.out.println("Digite novamente a idade");
            idade = scanner.nextInt();
        }

        if (contadorDeRepeticao > 0) {
            double mediaIdades = (double) somaIdade / contadorDeRepeticao;
            System.out.printf("Media das idades %.2f%n", mediaIdades);
        } else {
            System.out.println("impossivel calcular");
        }
        scanner.close();
    }
}
