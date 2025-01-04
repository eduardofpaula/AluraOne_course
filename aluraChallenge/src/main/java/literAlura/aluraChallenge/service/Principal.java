package literAlura.aluraChallenge.service;

import literAlura.aluraChallenge.entities.Book;

import java.util.Scanner;

public class Principal {

    private Scanner escolha = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();
    private final String endereco = "https://gutendex.com/books/?";


    public void menu(){
        int opcao = 1;
        while(opcao != 0) {
            String menu = """
                    ------------------
                    Escolha uma opção:
                    1 - Buscar Livro por Titulo
                    2 - Listar Livros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores vivos em um Determinado ano
                    5 - Listar Livros em um determinado Idioma
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = escolha.nextInt();
            escolha.nextLine();

            switch (opcao) {
                case 1 -> buscarLivroPorTitulo();
//                case 2 -> listarLivrosRegistrados();
//                case 3 -> listarAutoresRegistrados();
//                case 4 -> listarAutoresVivosEmAno();
//                case 5 -> listarLivrosEmIdioma();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public void buscarLivroPorTitulo() {
        System.out.println("Digite o titulo do livro: ");
        String titulo1 = escolha.nextLine();
        String titulo2 = titulo1.replace(" ", "%20");
        ConsumoAPI consumoAPI = new ConsumoAPI();
        consumoAPI.obterDados(endereco + "search=" + titulo2);
        ConverteDados converteDados = new ConverteDados();
        converteDados.obterDados(consumoAPI.obterDados(endereco + "search=" + titulo2), Book.class);
        System.out.println(consumoAPI.obterDados(endereco + "search=" + titulo2));
    }


}
