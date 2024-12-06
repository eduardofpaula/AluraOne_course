package desafios;

public class Aluno {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibirInfo() {
        System.out.printf("Nome do aluno: " + nome);
        System.out.printf("\nIdade do aluno: " + idade);
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno("Eduardo", 24);
        aluno.exibirInfo();
    }
}
