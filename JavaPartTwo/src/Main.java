import entities.Estudos;
import entities.Soma;
import entities.Subtracao;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        System.out.println("Ola, Eduardo");
        System.out.println("Tudo bem?");

        Scanner sc = new Scanner(System.in);
        System.out.print("\nAnote seu estudos: ");
        String nota = sc.nextLine();

        System.out.println("\nVAMOS SOMAR e SUBTRAIR");
        System.out.print("Escreva primeiro numero para SOMA E SUBTRAÇÃO: ");
        Double n1 = sc.nextDouble();
        System.out.print("Escreva segundo numero para SOMA E SUBTRAÇÃO: ");
        Double n2 = sc.nextDouble();

        // criação objeto e estanciando variaveis
        Estudos estudos = new Estudos(nota);
        Soma soma = new Soma(n1,n2);
        Subtracao subtracao = new Subtracao(n1,n2);

        System.out.println("\nSua anotação de Estudo: " + nota);
        System.out.println("Resultado da soma: " + soma.somar(n1,n2));
        System.out.println("Resultado da subtração: " + subtracao.subtrair(n1,n2));
    }
}