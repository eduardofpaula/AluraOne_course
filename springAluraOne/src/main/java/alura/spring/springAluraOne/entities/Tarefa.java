package alura.spring.springAluraOne.entities;

public class Tarefa {
    private String descricao;
    private boolean finalizado;
    private String pessoaResponsavel;

    public Tarefa(String descricao, boolean finalizado, String pessoaResponsavel) {
        this.descricao = descricao;
        this.finalizado = finalizado;
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public Tarefa(){
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public String getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(String pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", finalizado=" + finalizado +
                ", pessoaResponsavel='" + pessoaResponsavel + '\'' +
                '}';
    }
}
