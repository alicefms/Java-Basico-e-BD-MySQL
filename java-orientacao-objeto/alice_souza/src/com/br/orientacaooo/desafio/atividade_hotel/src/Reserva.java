import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Reserva {
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reserva(int roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int duration(){
        return (int) Duration.between(checkIn.toInstant(), checkOut.toInstant()).toDays();
    }

    public void updateDates(Date in, Date out){
        this.setCheckIn(in);
        this.setCheckOut(out);
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        return '\n' + "---Reserva--- " +'\n' +
                "Quarto = " + roomNumber + '\n' +
                "Entrada = " + f.format(checkIn)+'\n' +
                "Saida = " + f.format(checkOut) +'\n' +
                "Duração da reserva = " + duration() + " dia(s).";
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
