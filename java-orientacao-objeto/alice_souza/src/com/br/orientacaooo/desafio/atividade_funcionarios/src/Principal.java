import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        System.out.println("Quantos funcionários deseja cadastrar?");
        int N = scan.nextInt();
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            System.out.println("É terceirizado? \n (digite 1 se for terceirizado, ou outro numero se não for)");
            int opcao = scan.nextInt();
            scan.nextLine();
            System.out.println("Qual o nome?");
            String nome = scan.nextLine();
            System.out.println("Quantas horas foram trabalhadas?");
            int horas = scan.nextInt();
            System.out.println("Qual o valor pago por hora?");
            double valorHora = scan.nextDouble();
            if (opcao == 1) {
                System.out.println("Qual o valor da despesa adicional?");
                double despesaAdicional = scan.nextDouble();
                Funcionario f = new FuncionarioTerceirizado(nome, horas, valorHora, despesaAdicional);
                listaFuncionarios.add(f);
            } else {
                Funcionario f = new Funcionario(nome, horas, valorHora);
                listaFuncionarios.add(f);
            }
        }

            System.out.println("LISTA DE FUNCIONÁRIOS");
            for (Funcionario f: listaFuncionarios) {
                System.out.println();
                System.out.println("Nome: " + f.getNome());
                System.out.println("Pagamento: " + f.pagamento());
            }

    }
}
