import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Digite o quarto da reserva:");
            int quarto = scan.nextInt();
            System.out.println("Digite a data de entrada (dd-MM-yyyy):");
            scan.nextLine();
            Date entrada = f.parse(scan.next());
            System.out.println("Digite data de saída (dd-MM-yyyy):");
            Date saida = f.parse(scan.next());
            if (!saida.after(entrada)) {
                System.out.println("Erro ao fazer a reserva. A data de check-out deve ser depois da data de check-in");
            } else {
                Reserva r = new Reserva(quarto, entrada, saida);
                System.out.println(r);
                System.out.println("Para atualizar a reserva, insira novas datas de entrada e de saída: \n Nova entrada (dd-MM-yyyy): ");
                Date novaEntrada = f.parse(scan.next());
                System.out.println("Nova saída (dd-MM-yyyy):");
                Date novaSaida = f.parse(scan.next());
                Date hoje = new Date();
                if (novaEntrada.before(hoje)) {
                    System.out.println("Erro ao atualizar reserva. o check-in nao pode ser antes de hoje");
                } else if (novaSaida.before(novaEntrada)) {
                    System.out.println("Erro ao atualizar reserva. A data de saída deve ser posterior à entrada");
                } else {
                    r.updateDates(novaEntrada, novaSaida);
                    System.out.println(r);
                    scan.close();
                }
            }
        } catch (ParseException | InputMismatchException e) {
            System.out.println("Dados inseridos em formato incompatível");
        }
    }
}
