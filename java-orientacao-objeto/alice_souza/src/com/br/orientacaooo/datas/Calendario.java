import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Calendario {
    public static void main(String[] args) {
        Date data = Date.from(Instant.parse("2021-06-18T15:52:09Z"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Data formatada " + sdf.format(data));
        Calendar calendar = Calendar.getInstance();
        System.out.println("variável calendar " + calendar);

        calendar.setTime(data);
        int minuto = calendar.get(Calendar.MINUTE);
        int mes = calendar.get(Calendar.MONTH);

        System.out.println("minutos: " + minuto);
        System.out.println("Mês: " + mes);
        System.out.println();

        calendar.add(Calendar.HOUR_OF_DAY, 2);
        data = calendar.getTime();
        System.out.println("Data formatada: " + sdf.format(data));
    }
}
