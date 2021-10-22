package com.br.orientacaooo.desafio;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConsultaDAO {

    ArrayList<Consulta> consultas = new ArrayList<Consulta>();

    /*
        CRUD
    create: marcar
    read : consultar
    update: remarcar
    delete: cancelar

    */

    public void marcar(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void mostrarAgenda() {
        System.out.println("--Agenda Completa--");
        System.out.println(consultas);
    }

    public void consultar(int senha) {
        for (Consulta c : consultas) {
            if (c.getSenhaConsulta() == senha) {
                System.out.println("A consulta procurada é: ");
                System.out.println(c);
            }
        }
    }

    public void remarcar(int senha, LocalDate novaData) {
        for (Consulta c : consultas) {
            if (c.getSenhaConsulta() == senha) {
                c.setData(novaData);
                System.out.println("Consulta remarcada: ");
                System.out.println(c);
            }
        }
    }

    public void cancelar(int senha) {
        for (Consulta c : consultas) {
            if (c.getSenhaConsulta() == senha) {
                consultas.remove(c);
                System.out.println("Consulta cancelada");
            }
        }
    }

    public void atender(int dentistaCro, int pacienteCodigo) {
        for (Consulta c : consultas) {
            if ((c.getDentistaCro() == dentistaCro) && (c.getPacienteCodigo() == pacienteCodigo)) {
                consultas.remove(c);
                System.out.println("Paciente atendido. Consulta removida da agenda");
            } else
                System.out.println("Não existe agendamento para este paciente com este dentista");
        }

    }
}
