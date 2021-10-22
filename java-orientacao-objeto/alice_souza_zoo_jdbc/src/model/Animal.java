package model;

import java.time.LocalDate;

public class Animal {

        private String nomeAnimal;
        private String especie;
        private String raca;
        private String cor;
        private String sexo;
        private boolean morto;
        private int dono;
        private String dataNascimento;
        private String dataCadastro;


    public Animal(String nomeAnimal, String especie, String raca, String cor, String sexo, int dono, String dataNascimento, String dataCadastro) {
        this.nomeAnimal = nomeAnimal;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.sexo = sexo;
        this.dono = dono;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;

    }


    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isMorto() {
        return morto;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getDono() {
        return dono;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }


    @Override
    public String toString() {
        return  '\n' + "nome = " + nomeAnimal + '\n' +
                "especie = " + especie + '\n' +
                "raca= " + raca + '\n' +
                "cor= " + cor + '\n' +
                "sexo = " + sexo + '\n' +
                "dono = " + dono + '\n' +
                "dataNascimento = " + dataNascimento + '\n' +
                "dataCadastro = " + dataCadastro + '\n'
                ;
    }
}
