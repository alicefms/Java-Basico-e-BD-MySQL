package com.br.orientacaooo.model.entity;
// OBJETO QUE REPRESENTA MINHA TABELA NO BANCO -COM AS PARTICULARIDADES DO JAVA

public class Produto {
    private int codigoProduto;
    private String descricaoProduto;
    private Double precoProduto;
    private int codigoFornecedor;

    public Produto(){}

    public Produto(String descricaoProduto, Double precoProduto, int codigoFornecedor){
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.codigoFornecedor = codigoFornecedor;
    }

    public Produto(int codigoProduto, String descricaoProduto, Double precoProduto, int codigoFornecedor){
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.codigoFornecedor = codigoFornecedor;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return '\n' +
                "codigo = " + codigoProduto + '\n' +
                "descricao = " + descricaoProduto + '\n' +
                "preço = " + precoProduto + '\n'+ "Fornecedor (código) = " + codigoFornecedor+
                '\n';
    }
}
