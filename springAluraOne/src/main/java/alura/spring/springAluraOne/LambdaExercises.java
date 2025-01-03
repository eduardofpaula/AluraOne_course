package alura.spring.springAluraOne;

import alura.spring.springAluraOne.entities.Pessoa;
import alura.spring.springAluraOne.entities.Produto;
import alura.spring.springAluraOne.interfaces.*;

import java.util.*;
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

        // filtrando pessoas maiores de idade, ordenando por nome e imprimindo
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

        // encontrando o maior numero da lista
        List<Integer> numeros2 = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> maiorNumero = numeros2.stream()
                .max(Integer::compare);
        maiorNumero.ifPresent(System.out::println);

        // agrupando palavras por tamanho
        List<String> palavras3 = Arrays.asList("java", "stream", "lambda", "code");
        Map<Integer, List<String>> tamanhos1 = palavras3.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(tamanhos1);

        // concatenando elementos da lista
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        String resultado1 = nomes.stream()
                .collect(Collectors.joining(", "));
        System.out.println(resultado1);

        // reduzindo uma lista de inteiros
        List<Integer> numeros5 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int somaQuadrados = numeros5.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                // reduce recebe um valor inicial e uma função de acumulação
                .reduce(0, Integer::sum);
        System.out.println(somaQuadrados);

        // particionando numeros impares e pares
        List<Integer> numeros4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> particionados = numeros4.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Pares: " + particionados.get(true));
        System.out.println("Ímpares: " + particionados.get(false));

        // agrupando produtos por categoria
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Fone de Ouvido", 100.0, "Eletrônicos"),
                new Produto("Caneta", 5.0, "Papelaria")
        );

        Map<String,List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::categoria));
        System.out.println(produtosPorCategoria);

        // quantidade de produtos por categoria
        List<Produto> produtos1 = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Fone de Ouvido", 100.0, "Eletrônicos"),
                new Produto("Caneta", 5.0, "Papelaria")
        );

        Map<String, Long> contagemPorCategoria = produtos1.stream()
                .collect(Collectors.groupingBy(Produto::categoria, Collectors.counting()));
        System.out.println(contagemPorCategoria);

        // converter lista de string em lista de numeros, se a conversao falhar, ignora o valor
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        List<Integer> numeros6 = input.stream()
                // map retorna um stream de inteiros, mas pode conter valores nulos
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(numeros6);

        System.out.println(verificarPalindromo("Subi no onibus"));
        System.out.println(verificarPalindromo("Java"));




    }

    // metodo para verificar se uma string é palindromo
    public static boolean verificarPalindromo(String string){
        String semEspacos = string.replaceAll(" ", "").toLowerCase();
        return new StringBuilder(semEspacos).reverse().toString().equals(semEspacos);
    }


}
