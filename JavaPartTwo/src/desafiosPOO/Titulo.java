package desafiosPOO;

//Crie uma classe Titulo com um atributo nome do tipo String. Implemente a interface Comparable na classe para que seja possível ordenar uma lista de objetos Titulo.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Titulo implements Comparable<Titulo> {
    private String nome;

    public Titulo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int compareTo(Titulo titulo) {
        return this.nome.compareToIgnoreCase(titulo.getNome());
    }


    public static void main(String[] args) {
        Titulo titulo1 = new Titulo("Poderoso chefão");
        Titulo titulo2 = new Titulo("O senhor dos anéis");
        Titulo titulo3 = new Titulo("carros");
        Titulo titulo4 = new Titulo("avatar");

        List<Titulo> listaDeTitulos = new ArrayList<>();

        listaDeTitulos.add(titulo1);
        listaDeTitulos.add(titulo2);
        listaDeTitulos.add(titulo3);
        listaDeTitulos.add(titulo4);

        Collections.sort(listaDeTitulos);

        for (Titulo titulo : listaDeTitulos) {
            System.out.println(titulo);
        }

    }
}
