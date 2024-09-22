package desafios;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int tentativas = 0;
        double numAleatorio = new Random().nextInt(100);
        double numEscolhido = 0;

        while(tentativas <= 10){

            System.out.println("Digite um numero de 1 a 100");
            numEscolhido = sc.nextDouble();

            if(numEscolhido == numAleatorio){
                System.out.println("PARABENS VC ACERTOU!!");
                break;
            } else if (numEscolhido < numAleatorio) {
                System.out.println("O NUMERO DESEJADO É MENOR, CONTINUE TENTANDO ");
            } else {
                System.out.println("O NUMERO DESEJADO É MAIOR, CONTINUE TENTANDO ");
            }

            tentativas++;
        }

        if (tentativas == 10 && numEscolhido != numAleatorio) {
            System.out.println("Você não conseguiu acertar o número em 10 tentativas. O número era: " + numAleatorio);
        }


    }
}
