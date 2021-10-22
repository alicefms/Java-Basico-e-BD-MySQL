package com.br.orientacaooo.model.entity;

public class Fornecedor {
    private int codigoFornecedor;
    private String nomeFornecedor;
    private String CNPJ;

    public Fornecedor(){}

    public Fornecedor(String nomeFornecedor, String CNPJ){
        this.nomeFornecedor = nomeFornecedor;
        this.CNPJ = CNPJ;
    }

    public Fornecedor(int codigoFornecedor, String nomeFornecedor, String CNPJ){
        this.codigoFornecedor = codigoFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.CNPJ = CNPJ;
    }

    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    @Override
    public String toString() {
        return
                '\n' + "código = " + codigoFornecedor + '\n'+
                "nome = " + nomeFornecedor + '\n' +
                "CNPJ = " + CNPJ + '\n' ;
    }
}

