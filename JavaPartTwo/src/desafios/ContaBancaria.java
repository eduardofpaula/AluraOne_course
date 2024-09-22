package desafios;

import java.util.Locale;
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String nome = "Eduardo Farias";
        String conta = "Corrente";
        double saldo = 2500.00;

        System.out.println("***************************************");
        System.out.println("Dados iniciais dos Cliente:\n");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo Conta: " + conta);
        System.out.println("Saldo inicial: R$ " + saldo);
        System.out.println("***************************************");

        int opcao = 1;

        while(opcao != 4){
            double valor = 0;
            System.out.println("""
                    \nOperações
                    
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair""");
            opcao = sc.nextInt();
            if(opcao == 1){
                System.out.println("O saldo atual é de R$ " + saldo);
            } else if (opcao == 2) {
                System.out.print("\nDeseja o valor a ser recebido: ");
                saldo += valor = sc.nextDouble();
                System.out.println("Saldo atualizado: " + saldo);
            } else if (opcao == 3) {
                System.out.print("\nDigite o valor que deseja transferir: ");
                valor = sc.nextDouble();
                if(valor > saldo){
                    System.out.println("\nNão há saldo suficiente para fazer essa transferência!");
                }else {
                    saldo -= valor;
                    System.out.println("Saldo atualizado: " + saldo);
                }
            }else if(opcao == 4) {
                System.out.println("\nTchau Tchau, obrigado");
            }
        }
    }
}
