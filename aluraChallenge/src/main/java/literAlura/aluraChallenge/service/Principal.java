package literAlura.aluraChallenge.service;

import literAlura.aluraChallenge.DTO.Author;
import literAlura.aluraChallenge.DTO.Book;
import literAlura.aluraChallenge.DTO.Result;
import literAlura.aluraChallenge.entities.Livros;
import literAlura.aluraChallenge.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class Principal {

    private final Scanner escolha = new Scanner(System.in);
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConverteDados converteDados = new ConverteDados();
    private final String endereco = "https://gutendex.com/books/?";
    private final LivrosRepository livrosRepository;

    // Construtor para injeção de dependência
    @Autowired
    public Principal(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }

    public void menu() {
        int opcao = 1;
        while (opcao != 0) {
            String menu = """
                    
                    Bem-vindo ao sistema de busca de livros! LITER ALURA!!!!!!
                    ------------------
                    Escolha uma opção:
                    1 - Buscar Livro por Título
                    2 - Listar Livros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores vivos em um Determinado Ano
                    5 - Listar Livros em um Determinado Idioma
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = escolha.nextInt();
            escolha.nextLine();

            switch (opcao) {
                case 1 -> buscarLivroPorTitulo();
                case 2 -> buscarLivrosRegistrados();
                case 3 -> buscarAutoresRegistrados();
                case 4 -> autoresVivos();
                case 5 -> idiomaLivros();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }

    public void buscarLivroPorTitulo() {
        System.out.println("Digite o título do livro: ");
        String titulo1 = escolha.nextLine();
        String titulo2 = titulo1.replace(" ", "%20");

        String dadosAPI = consumoAPI.obterDados(endereco + "search=" + titulo2);

        Result convertido = converteDados.obterDados(dadosAPI, Result.class);

        if (convertido != null && convertido.results() != null && convertido.results().length > 0) {
            for (Book livro : convertido.results()) {
                System.out.println(" ");
                System.out.println("Título: " + livro.titulo());
                System.out.println("Autor: " + Arrays.stream(livro.autores())
                        .map(Author::nome)
                        .filter(nome -> nome != null && !nome.isEmpty()) // Ensure nome is not null or empty
                        .collect(Collectors.joining(",")));
                System.out.println("Ano de Morte:" + Arrays.stream(livro.autores())
                        .map(Author::anoMorte)
                        .filter(anoMorte -> anoMorte != 0)
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
                System.out.println("Idiomas: " + String.join(", ", livro.idiomas()));
                System.out.println("Downloads: " + livro.downloads());
                System.out.println(" ");

                try {
                    Livros livroEntidade = converterParaEntidade(livro);
                    System.out.println(livroEntidade.getIdLivro() + " " + livroEntidade.getNome() + " " + livroEntidade.getAutor() + " " + livroEntidade.getIdioma() + " " + livroEntidade.getNumDownloads());
                    livrosRepository.save(livroEntidade);
                    System.out.println("Livro salvo no banco de dados.");
                } catch (Exception e) {
                    System.out.println("Erro ao salvar livro no banco de dados: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Nenhum livro encontrado com o título informado.");
        }
    }

    public Livros converterParaEntidade(Book book) {
        return new Livros(
                null, // ID será gerado automaticamente pelo banco
                book.titulo(),
                book.autores()[0].nome(),
                book.autores()[0].anoMorte(),
                book.idiomas()[0],
                book.downloads()
        );
    }

    public void buscarLivrosRegistrados() {
        List<Livros> livros = livrosRepository.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado.");
        } else {
            for (Livros livro : livros) {
                System.out.println(" ");
                System.out.println("ID: " + livro.getIdLivro());
                System.out.println("Título: " + livro.getNome());
                System.out.println("Downloads: " + livro.getNumDownloads());
                System.out.println(" ");
            }
        }
    }

    public void buscarAutoresRegistrados() {
        List<Livros> autores = livrosRepository.findAll();
        if (autores.isEmpty()){
            System.out.println("Nenhum autor cadastrado");
        } else {
            for (Livros livros : autores){
                System.out.println(" ");
                System.out.println("ID: " + livros.getIdLivro());
                System.out.println("Nome autor: " + livros.getAutor());
                System.out.println("Ano de morte: " + livros.getAnoMorte());
            }
        }
    }

    public void autoresVivos(){
        System.out.println(" ");
        System.out.println("Digite o ano da morte: ");
        List<Object[]> autoresVivos = livrosRepository.autoresVivos(escolha.nextInt());
        if (autoresVivos.isEmpty()){
            System.out.println("Nenhum autor vivo encontrado neste ano.");
        } else {
            for (Object[] autor : autoresVivos) {
                System.out.println(" ");
                System.out.println("Nome autor: " + autor[0]);
                System.out.println("Ano de morte: " + autor[1]);
            }
        }
    }

    public void idiomaLivros() {
        System.out.println(" ");
        System.out.println("Digite o idioma desejado: ");
        List<Object[]> idiomaLivros = livrosRepository.findLivrosByIdioma(escolha.nextLine());
        if (idiomaLivros.isEmpty()){
            System.out.println("Nenhum livro encontrado com o idioma informado.");
        } else {
            for (Object[] livro : idiomaLivros) {
                System.out.println(" ");
                System.out.println("Titulo Livro: " + livro[0]);
                System.out.println("Idioma: " + livro[1]);
            }
        }

    }



}