package com.br.orientacaooo.server;

import com.br.orientacaooo.model.dao.ProdutoDAO;
import com.br.orientacaooo.model.entity.Produto;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class CadastroProdutos {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ProdutoDAO pDAO1 = new ProdutoDAO();
        //criação de produtos
       // Produto p = new Produto( "MACARRONADaaaaaaA", 18.0,6 );
      // p.setCodigoProduto(16);
        //Insere na lista - INSERT
        //pDAO1.save(p);

        //Lista os Produtos - SELECT
       // System.out.println(pDAO1.findAll());

        //Deleta produto - DELETE
       // pDAO1.delete(19);

        //merge - UPDATE
       // pDAO1.merge(p);
        System.out.println(pDAO1.findById(7));

/*
        //busca na lista - READ
        System.out.println("**** Exibe usando o método de Byanca *****");
        System.out.println(pDAO1.findAll2());
        System.out.println();
        System.out.println("**** Exibe usando o forEach *****");
        pDAO1.findAll();
        System.out.println();


       //Interação para deletar item

       Scanner scan = new Scanner(System.in);
        System.out.println("----Lista Atual----");
        pDAO1.findAll();
        System.out.println("Qual o código do item que deseja remover?");
        int itemARemover = scan.nextInt();
        pDAO1.delete2(itemARemover);
        pDAO1.findAll();

        scan.close();


        //Interação para detalhar item
        Scanner scan = new Scanner(System.in);
        System.out.println("----Lista Atual----");
        pDAO1.findAll();
        System.out.println("Qual o código do item que deseja detalhar?");
        int itemADetalhar = scan.nextInt();
        System.out.println(pDAO1.findOne(itemADetalhar));

        // INTERAÇÃO PARA ALTERAR DEFAULT ENTRANDO SOMENTE COM O CÓDIGO
        Scanner scan = new Scanner(System.in);
        System.out.println("----Lista Atual----");
        pDAO1.findAll();
        System.out.println("Qual o código do item que deseja Alterar?");
        int itemAAlterar = scan.nextInt();
        pDAO1.modify(itemAAlterar);
        pDAO1.findAll();


        // INTERAÇÃO PARA ALTERAR ENTRANDO COM CODIGO, DESCRIÇÃO E PREÇO
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        System.out.println("----Lista Atual----");
        pDAO1.findAll();
        System.out.println("Qual o código do item que deseja Alterar?");
        int itemAAlterar = scan.nextInt();
        System.out.println("Qual a nova descrição?");
        String descricaoNova = scan.next();
        scan.nextLine();
        System.out.println("E o preço?");
        Double precoNovo = scan.nextDouble();
        pDAO1.alter(itemAAlterar, descricaoNova, precoNovo);
        pDAO1.findAll();
*/
    }


}
