package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.PessoaFisica;
import entities.PessoaJuridica;
import entities.Contribuinte;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // LISTA DO TIPO GENERICO QUE ACEITA TODOS OS TIPOS
        List<Contribuinte> list = new ArrayList<Contribuinte>();

        System.out.print("Digite a quantidade de contribuintes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Contribuinte #" + i + " Dados: ");
            System.out.print("Pessoa fisica ou juridica (f/j)? ");
            char tipo = sc.next().charAt(0); // LENDO O PRIMEIRO STRING DIGITADO

            System.out.print("Nome: ");
            String nome = sc.next(); // NEXT SÓ ACEITA UMA PALAVRA SEM ESPAÇO
            System.out.print("Renda Anual: ");
            Double rendaAnual = sc.nextDouble();

            if (tipo == 'f') {
                System.out.print("Gastos com saude: ");
                Double gs = sc.nextDouble();
                list.add(new PessoaFisica(nome, rendaAnual, gs));

            } else {
                System.out.print("Numero de funcionarios: ");
                Integer numeroDeFuncionarios = sc.nextInt();
                list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
            }
        }

        System.out.println();
        System.out.println("IMPOSTOS PAGOS:");
        for (Contribuinte c : list) { // PRA CADA CONTRIBUINTE NA MINHA LISTA LIST...
            System.out.println(c.getNome() + ": $ " + String.format("%.2f", c.imposto()));
        }

        System.out.println();
        double soma = 0.0; // CADA FOR TER UM PROPOSITO UNICO / PRINCIPIO SOLID - RESPONSABILIDADE UNICA
        for (Contribuinte c : list) {
            soma += c.imposto();
        }
        System.out.println("TOTAL DE IPOSTOS: $ " + String.format("%.2f", soma));
        sc.close();
    }
}