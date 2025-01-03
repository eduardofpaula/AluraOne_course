package alura.spring.springAluraOne.entities;

public class Avaliacao<T> {
    private T item;
    private double nota;
    private String comentario;

    public Avaliacao(T item, double nota, String comentario) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        this.item = item;
        this.nota = nota;
        this.comentario = comentario;
    }

    public T getItem() {
        return item;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if(nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve ser entre 0 e 10");
        }
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "item=" + item +
                ", nota=" + nota +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
