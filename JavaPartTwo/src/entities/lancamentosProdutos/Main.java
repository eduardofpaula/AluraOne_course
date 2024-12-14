package entities.lancamentosProdutos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o limite do cartão de crédito: ");
        double limite = sc.nextDouble();
        CartaoCredito cartao = new CartaoCredito(limite);

        int escolha = 1;
        Compra compra = null;
        while (escolha != 0) {
            System.out.println("Digite 1 para adicionar uma compra, 2 para ver o limite do cartão ou 0 para sair: ");
            escolha = sc.nextInt();
            if (escolha == 1 && cartao.getLimite() > 0) {

                System.out.println("Digite a descrição da compra: ");
                String descricao = sc.nextLine();

                System.out.println("Digite o valor da compra: ");
                String valor = sc.nextLine();
                if(cartao.getLimite() < Double.parseDouble(valor)){
                    System.out.println("Limite do cartão insuficiente para realizar a compra!\nEscolha um valor mais baixo.");
                    continue;
                }

                compra = new Compra(descricao, valor);

                System.out.println("Compra adicionada com sucesso!");
                cartao.setLimite(cartao.getLimite() - Double.parseDouble(valor));
            } else if (escolha == 2) {
                System.out.println("Limite do cartão: " + cartao.getLimite());
            }
        }
        sc.close();
        System.out.println("*********************************");
        System.out.println("Compras realizadas: ");
        System.out.println("*********************************");
        System.out.println("Nome da compra: " + compra.getValor());
        System.out.println("Descrição da compra: " + compra.getDescricao());

    }
}
