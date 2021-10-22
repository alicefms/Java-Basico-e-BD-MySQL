import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        int opcao = 1;
        Account account = null;
        do {
            System.out.println("Como deseja criar a conta:" +'\n' +
                    "1 - Cadastrar uma conta (COM depósito inicial)" + '\n' +
                    "2 - Cadastrar uma conta (SEM depósito inicial)");
            opcao = scan.nextInt();
            switch (opcao){
                case 1 : {
                    System.out.println("Informe o número da conta: ");
                    int conta = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Informe o nome do titular: ");
                    String nome = scan.nextLine();
                    System.out.println("Informe o valor do depósito inicial: ");
                    Double deposito = scan.nextDouble();
                    account = new Account(conta, nome, deposito);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println(account);
                    break;
                }

                case 2 : {
                    System.out.println("Informe o número da conta: ");
                    int conta = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Informe o nome do titular: ");
                    String nome = scan.nextLine();
                    account = new Account(conta, nome);
                    System.out.println("Conta criada com sucesso!");
                    System.out.println(account);
                    break;
                }

                default:
                    System.out.println("Opção inválida ");
                    break;
            }
        }while (opcao !=1 && opcao !=2);

        do {
            System.out.println("O que deseja fazer agora?" + '\n' +
                    "1 - Realizar um depósito" +'\n' +
                    "2 - Efetuar um saque" +'\n' +
                    "0 - Finalizar o programa");

            opcao = scan.nextInt();
            switch (opcao) {
                case 1: {
                    System.out.println("Informe o valor do depósito: ");
                    Double money = scan.nextDouble();
                    account.deposit(money);
                    System.out.println("Depósito efetuado com sucesso");
                    System.out.println(account);
                    break;

                }
                case 2 : {
                    System.out.println("Informe o valor do saque: ");
                    Double money = scan.nextDouble();
                    account.withdraw(money);
                    System.out.println("Saque efetuado com sucesso");
                    System.out.println(account);
                    break;
                }
                case 0 :
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }while (opcao !=0);
    }
}
