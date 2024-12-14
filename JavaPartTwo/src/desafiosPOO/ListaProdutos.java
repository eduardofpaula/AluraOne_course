package desafiosPOO;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutos {
    private String nome;
    private double preco;

    public ListaProdutos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static void main(String[] args) {
        ListaProdutos produto1 = new ListaProdutos("TV", 100);
        ListaProdutos produto2 = new ListaProdutos("Geladeira", 200);
        ListaProdutos produto3 = new ListaProdutos("Fogão", 300);
        ListaProdutos produto4 = new ListaProdutos("Microondas", 400);
        ListaProdutos produto5 = new ListaProdutos("Liquidificador", 500);

        ArrayList<ListaProdutos> listaProdutos = new ArrayList<>();

        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);
        listaProdutos.add(produto4);
        listaProdutos.add(produto5);

        int quantidade = 0;
        double somaProdutos = 0;
        for (ListaProdutos item : listaProdutos) {
            quantidade += 1;
            somaProdutos += item.getPreco();
        }

        double media = somaProdutos / quantidade;
        System.out.println("Média de produtos: " + media);

    }
}
