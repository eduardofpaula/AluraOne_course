package alura.spring.springAluraOne;

import alura.spring.springAluraOne.entities.Pessoa;
import alura.spring.springAluraOne.interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExercises {
    public static void main(String[] args) {
        //expressao lambda para multiplicar dois numeros
        Multiplicacao multiplicacao = (a, b) -> a * b;
        System.out.println(multiplicacao.multiplicar(2, 3));

        //expressao lambda para verificar se um numero é primo
        VerificarPrimo primo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(primo.verificarPrimo(7));
        System.out.println(primo.verificarPrimo(8));

        //expressao lambda para transformar uma string em maiuscula
        TransformarString string = String::toUpperCase;
        System.out.println(string.transformar("teste"));

        //expressao lambda para verificar se uma string é palindromo
        Palindromo palindromo = s -> s.contentEquals(new StringBuilder(s).reverse());
        System.out.println(palindromo.verificarPalindromo("arara"));
        System.out.println(palindromo.verificarPalindromo("teste"));
        System.out.println(palindromo.verificarPalindromo("java"));

        //expressao lambda para multiplicar todos os elementos de uma lista por 3
        List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        listaInteiros.replaceAll(n -> n * 3);
        System.out.println(listaInteiros);

        //expressao lambda para ordenar uma lista de strings
        List<String> listaStrings = Arrays.asList("z", "y", "x", "w");
        listaStrings.sort(String::compareTo);
        System.out.println(listaStrings);

        //expressao lambda para dividir dois numeros
        Divisao divisao = (a, b) -> {
            if (b == 0) throw new ArithmeticException("Divisão por zero");
            return a / b;
        };

        try {
            System.out.println(divisao.dividir(10, 2));
            System.out.println(divisao.dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        List<String> palavras = Arrays.asList("Java", "Stream", "Operações", "Intermediárias");

        // expressao lambda para mapear o tamanho de cada palavra
        List<Integer> tamanhos = palavras.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
        System.out.println(tamanhos);

        // filtre apenas os números pares e imprima-os.
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        // transformando elementos da lista com letra maiuscula
        List<String> palavras1 = Arrays.asList("java", "stream", "lambda");
        palavras1.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        // filtrar numeros pares, multiplicar por 2 e coletar resultados e colocalos em uma nova lista
        List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> resultado = numeros1.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(resultado);

        // filtrando dados duplicados
        List<String> palavras2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        List<String> unicas = palavras2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(unicas);

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );
        pessoas.stream()
                .filter(p -> p.idade() >= 18)
                .map(Pessoa::nome)
                .sorted()
                .forEach(System.out::println);

    }


}
