package desafiosPOO;

public class Carro2 {
    private String nomeModelo;
    private double precoAno1;
    private double precoAno2;
    private double precoAno3;

    public void definirModelo(String nome) {
        this.nomeModelo = nome;
    }

    public void definirPrecos(double precoAno1, double precoAno2, double precoAno3) {
        this.precoAno1 = precoAno1;
        this.precoAno2 = precoAno2;
        this.precoAno3 = precoAno3;
    }

    public double maiorPreco() {
        double maiorPreco = precoAno1;

        if (maiorPreco <= precoAno2) {
            maiorPreco = precoAno2;
        }
        if (maiorPreco <= precoAno3) {
            maiorPreco = precoAno3;
        }

        return maiorPreco;
    }

    public double menorPreco() {
        double menorPreco = precoAno1;

        if (menorPreco >= precoAno2) {
            menorPreco = precoAno2;
        }

        if (menorPreco >= precoAno3) {
            menorPreco = precoAno3;
        }
        return menorPreco;
    }

    public void exibirInfo() {
        System.out.println("Modelo: " + nomeModelo);
        System.out.println("Preço Ano 1: " + precoAno1);
        System.out.println("Preço Ano 2: " + precoAno2);
        System.out.println("Preço Ano 3: " + precoAno3);
        System.out.println("Menor Preço: " + menorPreco());
        System.out.println("Menor Preço: " + maiorPreco());
    }


    public static void main(String[] args) {
        Carro2 carro = new Carro2();
        carro.definirPrecos(10000, 12000, 13000);
        carro.definirModelo("Fusca");
        carro.exibirInfo();
    }

}
