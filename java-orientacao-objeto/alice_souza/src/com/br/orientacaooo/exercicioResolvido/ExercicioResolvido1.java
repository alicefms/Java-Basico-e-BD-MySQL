package com.br.orientacaooo.exercicioResolvido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioResolvido1 {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        System.out.println("Quantos funcionários deseja cadastrar?");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println("Digite o id");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o nome:");
            String nome = scan.nextLine();
            System.out.println("Digite o salário:");
            double salario = scan.nextDouble();
            for (Funcionario f : funcionarios) {
                if (f.getId() == id) System.out.println("id já existe"); break;
                }
            funcionarios.add(new Funcionario(id, nome, salario));
            System.out.println("Funcionário cadastrado");
        }
        System.out.println("Deseja aumentar o salario de quem em quanto? (id, %)");
        int idFuncionario = scan.nextInt();
        scan.nextLine();
       /* double percentual = scan.nextDouble();
        for (Funcionario f : funcionarios) {
            if (f.getId() == idFuncionario)
            {  f.incrementarSalario(idFuncionario, percentual); break;}
        }
*/
        Funcionario funcAumento = funcionarios.stream().filter(x->x.getId() == idFuncionario).findFirst().orElse(null);
        if(funcAumento == null){
            System.out.println("O id informado não existe");}
        else{
            System.out.println("Qual o percentual do aumento?");
            double porcentagem = scan.nextDouble();
            funcAumento.incrementarSalario(idFuncionario, porcentagem);

        }
        scan.close();
    }


    public boolean hasId(List<Funcionario> employeeList, int id){
        Funcionario funcionario = employeeList.stream().filter(x->x.getId() == id).findFirst().orElse(null);
        return funcionario != null;
    }


}