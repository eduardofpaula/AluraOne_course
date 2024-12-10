package desafiosPOO;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String olaMundo(){
        return "Ola Mundo";
    }

    @Override
    public String toString() {
        return "Pessoa: " +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public static void main(String[] args) {
        ArrayList listaDePessoas = new ArrayList<Pessoa>();
        listaDePessoas.add(new Pessoa("eduardo", 20));
        listaDePessoas.add(new Pessoa("Ana", 30));
        listaDePessoas.add(new Pessoa("Maria", 40));
        System.out.println(listaDePessoas);

        System.out.println("tamanho da lista de pessoas: " + listaDePessoas.size());
        System.out.println("primeira pessoa da lista " + listaDePessoas.getFirst());

    }
}
