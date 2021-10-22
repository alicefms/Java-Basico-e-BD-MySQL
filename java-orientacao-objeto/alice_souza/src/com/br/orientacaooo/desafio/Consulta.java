package com.br.orientacaooo.desafio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Consulta {
    private int pacienteCodigo;
    private int dentistaCro;
    private LocalDate data;
    private int senhaConsulta;



    public Consulta(int pacienteCodigo, int dentistaCro, LocalDate data, int senhaConsulta) {
        this.pacienteCodigo = pacienteCodigo;
        this.dentistaCro = dentistaCro;
        this.data = data;
        this.senhaConsulta = senhaConsulta;
    }

    public int getSenhaConsulta() {
        return senhaConsulta;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDentistaCro() {
        return dentistaCro;
    }

    public int getPacienteCodigo() {
        return pacienteCodigo;
    }

    @Override
    public String toString() {
        return
                '\n' + "Código do paciente = " + pacienteCodigo +'\n'+
                "CRO do dentista = " + dentistaCro + '\n' +
                "Data = " + data + '\n' + "Senha = " +senhaConsulta + '\n';
    }
}