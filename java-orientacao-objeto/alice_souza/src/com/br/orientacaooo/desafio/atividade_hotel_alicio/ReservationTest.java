package com.br.orientacaooo.desafio.atividade_hotel;

import com.br.orientacaooo.desafio.atividade_hotel.exception.ReservationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReservationTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Numero do quarto: ");
            int number = sc.nextInt();
            System.out.println("Data do Check-In (dd/MM/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Data do Check-Out (dd/MM/yyyy)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            System.out.println();
            System.out.println("Entre com as novas datas de atualização da reserva: ");

            System.out.println("Data do Check-In (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());

            System.out.println("Data do Check-Out (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reservation);

        } catch (ParseException e) {
            System.out.println("Formato inválido de data");
        } catch (ReservationException e) {
            System.out.println("Erro ao fazer a reserva: " + e.getMessage());
        }
        sc.close();
    }
}
