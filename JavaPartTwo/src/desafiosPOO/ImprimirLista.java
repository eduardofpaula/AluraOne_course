package desafiosPOO;

import java.util.ArrayList;

public class ImprimirLista {
    public static void main(String[] args) {
        ArrayList<String> listaDePessoas = new ArrayList<>();

        listaDePessoas.add("eduardo");
        listaDePessoas.add("ana");
        listaDePessoas.add("vitor");
        listaDePessoas.add("aloha");

        for (String item : listaDePessoas){
            System.out.println("Nome: " + item);
        }
    }
}
