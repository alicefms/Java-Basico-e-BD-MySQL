import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        double arrecadado = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos contribuintes deseja cadastrar?");
        int N = scan.nextInt();
        List<TaxPayer> listaContribuintes = new ArrayList<>();
        for(int i = 0; i<N; i++){
            System.out.println("O contribuinte é Pessoa Física(1) ou Pessoa Jurídica(2)?");
            int contribuinte = 0;
            do {
                contribuinte = scan.nextInt();}
            while(contribuinte != 1 && contribuinte !=2);

            System.out.println("Digite o nome: ");
            scan.nextLine();
            String nome = scan.nextLine();
            System.out.println("Digite a renda anual: ");
            Double renda = scan.nextDouble();
            if(contribuinte == 1) {
                System.out.println("Digite os gastos com a saúde: ");
                Double gSaude = scan.nextDouble();
                TaxPayer pagante = new Individual(nome, renda, gSaude);
                listaContribuintes.add(pagante);
            }
            else if (contribuinte == 2){
                System.out.println("Digite o número de funcionários: ");
                int nFuncionarios = scan.nextInt();
                TaxPayer pagante = new Company(nome, renda, nFuncionarios);
                listaContribuintes.add(pagante);
            }
        }
        for (TaxPayer pagante: listaContribuintes) {
            System.out.println();
            System.out.println(pagante.getName());
            System.out.println(pagante.tax());
            arrecadado += pagante.tax();

        }
        System.out.println("Total arrecadado: " +arrecadado);
    }
}
