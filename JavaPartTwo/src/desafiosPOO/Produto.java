package desafiosPOO;

import java.util.ArrayList;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto() {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public static void main(String[] args) {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();

        produto1.setNome("TV");
        produto1.setPreco(100);
        produto2.setQuantidade(2);

        produto2.setNome("Geladeira");
        produto2.setPreco(200);
        produto2.setQuantidade(3);

        produto3.setNome("Fogão");
        produto3.setPreco(300);
        produto3.setQuantidade(4);

        ArrayList listaProdutos = new ArrayList<>();
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);

        System.out.println("Tamanho da lista de produtos: " + listaProdutos.size());
        System.out.println("Produto na posição 2: " + listaProdutos.get(1));
        System.out.println(listaProdutos.toString());

    }
}
