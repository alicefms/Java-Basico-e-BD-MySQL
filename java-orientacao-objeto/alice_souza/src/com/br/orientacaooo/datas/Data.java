import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Data {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format3 = new SimpleDateFormat("dd/MM/yyyy");
        format3.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date x = new Date(System.currentTimeMillis());

        System.out.println("CRU: \n"+x);
        System.out.println("Formatado: \n"+ format3.format(x));
        Date x1 = new Date();
        Date x2 = new Date(System.currentTimeMillis()); // data atual
        Date x3 = new Date(0L); //pega o instante zero q começa a contar: 01/01/1970 à meia noite (-3h pdevido ao fuso)
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(x3);

        Date y1 = format3.parse("25/11/1988");
        Date y2 = format3.parse("25/11/1988 15:52:09");
        Date y3 = Date.from(Instant.parse("2021-06-18T15:52:09Z"));
        System.out.println(y1);
        System.out.println(y2);
        System.out.println(y3);
    }
}