package com.br.orientacaooo.desafio;

import java.time.LocalDate;
import java.util.Scanner;

import static java.time.LocalDate.now;

public class Principal {
    public static void main(String[] args) {

        Dentista d1 = new Dentista("Semiramis", "Terto", "Ortodontia", 1233, true);
        Dentista d2 = new Dentista("Gabriel", "Ferrão", "Implante Dentário", 3548, true);
        Dentista d3 = new Dentista("Roberta", "Santos", "Endodontia", 0541, true);
        Paciente p1 = new Paciente(001,"Alice", "Souto", 23,'F', "8165258547", "Rua qulquercoisa, 212");
        Paciente p2 = new Paciente(002,"Júlia", "Souto", 47,'F', "8169999999", "Rua quarenta, 789");
        Paciente p3 = new Paciente(003,"Francisco", "Silva", 12,'M', "8188888847", "Rua vinte, 15");

        Consulta c1 = new Consulta(001, 1233, now(), 123456);
        Consulta c2 = new Consulta(002, 3548, now(), 21);
        Consulta c3 = new Consulta(003, 0541, now(), 7);

        ConsultaDAO agenDAO = new ConsultaDAO();
        agenDAO.marcar(c1);
        agenDAO.marcar(c2);
        agenDAO.marcar(c3);
 /*     agenDAO.mostrarAgenda();
        agenDAO.consultar(7);
        agenDAO.remarcar(123456, now());
        agenDAO.cancelar(21);
        agenDAO.atender(1233, 001);
        System.out.println(d1.relatar_indisponivel());
*/
        //Interação
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
        System.out.println("Agendamento Online \n \n Digite a opção desejada: \n 1- Marcar Consulta\n 2- Detalhar consulta \n 3- Remarcar Consulta \n 4- Cancelar Consulta \n 5- Atender Paciente \n 6- Mostrar agenda completa");

        opcao = scan.nextInt();
        switch (opcao){
            case 1:{
                System.out.println("digite o codigo do paciente, o CRO do dentista e uma senha numérica");
                agenDAO.marcar(new Consulta(scan.nextInt(), scan.nextInt(), now(), scan.nextInt()));
                break;}
            case 2: {
                System.out.println("digite a senha da sua consulta, para detalhes");
                agenDAO.consultar(scan.nextInt());
                break;}
            case 3: {
                System.out.println("Digite a senha da sua consulta e a nova data desejada");
                agenDAO.remarcar(scan.nextInt(), LocalDate.parse(scan.nextLine()));
                break;}
            case 4: {
                System.out.println("digite a senha da consulta para confirmar o cancelamento");
                agenDAO.cancelar(scan.nextInt());
                break;}
            case 5:{
                System.out.println("Digite o CRO do dentista e o código do paciente");
                agenDAO.atender(scan.nextInt(), scan.nextInt());
                break;}
            case 6:{
                agenDAO.mostrarAgenda();
                scan.nextLine();
            }
            default :
                System.out.println("pronto");;
        }

    } while (opcao != 0);
        scan.close();
}}
