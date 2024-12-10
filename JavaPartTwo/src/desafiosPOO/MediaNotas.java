package desafiosPOO;

public class MediaNotas {
    public static void main(String[] args) {
        double nota1 = 3.5;
        double nota2 = 3.5;
        double media = nota1 / nota2;
        System.out.println("A MEDIA ENTRE A NOTA 1 E NOTA 2 É:"  + media);
        double var1 = 3;
        int var2 = (int) var1;
        System.out.println("CASTING DA VARIAVEL DOUBLE PRA VARIAVEL INT: " + var2);
        char let = 'M';
        String let1 = "Meu genero é ";
        String mensagem = let1 + let;
        System.out.println(mensagem);
        double precoProduto = 10;
        int quantidade = 4;
        int valorTotal = (int) (quantidade * precoProduto);
        System.out.println("RESULTADO DA CONTA VALOR TOTAL: " + valorTotal);
        double valorEmDolares = 50;
        double valorReais = 4.95;
        double contaDolarReal = valorEmDolares * valorReais;
        System.out.println(valorEmDolares + " EM DOLARES EQUIVALE Á " + contaDolarReal + " EM REAIS");
        double precoOriginal = 150.00;
        double percentualDesconto = ((double) 20 /100) * precoOriginal;
        System.out.println("O VALOR DO PRODUTO COM DESCONTO É: " + percentualDesconto);
    }
}
