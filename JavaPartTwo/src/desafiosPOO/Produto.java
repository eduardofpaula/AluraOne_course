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
        Produto produto1 = new Produto("TV", 100, 2);
        Produto produto2 = new Produto("Bola", 50,1);
        Produto produto3 = new Produto("Celular", 200,3);

        ArrayList listaProdutos = new ArrayList<>();
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);
        listaProdutos.add(produto3);

        System.out.println("Tamanho da lista de produtos: " + listaProdutos.size());
        System.out.println("Produto na posição 2: " + listaProdutos.get(1));
        System.out.println(listaProdutos.toString());

    }
}
