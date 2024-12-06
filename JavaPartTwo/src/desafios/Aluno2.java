package desafios;

import java.util.List;

public class Aluno2 {
    private String nome;
    private double notas;

    public double calcularMedia(List<Aluno2> aluno2s) {
        // inicia variavel para armazenar a soma das notas
        double soma = 0;
        // percorre a lista de alunos e adiciona as notas a variavel soma
        for (Aluno2 aluno2 : aluno2s) {
            soma += aluno2.getNotas();
        }
        // retorna a media das notas
        return soma / aluno2s.size();
    }

    public Aluno2(String nome, double notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotas() {
        return notas;
    }

    public void setNotas(double notas) {
        this.notas = notas;
    }
}
