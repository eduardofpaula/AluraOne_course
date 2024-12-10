package desafiosPOO;

public class Produto2 {
    private String nome;
    private double preco;

    public void aplicarDesconto(double percent){
        this.preco -= percent;
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
}
