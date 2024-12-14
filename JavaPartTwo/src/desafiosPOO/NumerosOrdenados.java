package desafiosPOO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumerosOrdenados {

    public static void main(String[] args) {

        List<Integer> numerosOrdenados = new ArrayList<>();
        numerosOrdenados.add(423);
        numerosOrdenados.add(12);
        numerosOrdenados.add(133);
        numerosOrdenados.add(311);
        numerosOrdenados.add(52);
        numerosOrdenados.add(74231);

        for (int i = 0; i <= numerosOrdenados.size()-1; i++) {
            System.out.println("Numero de posição " + i + ": " + numerosOrdenados.get(i));
        }
        System.out.println("");
        Collections.sort(numerosOrdenados);
        for (Integer item : numerosOrdenados){
            System.out.println("Numero de posição " + numerosOrdenados.indexOf(item) + ": " + item);
        }
    }
}

