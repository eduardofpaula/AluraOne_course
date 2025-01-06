package literAlura.aluraChallenge.service;

import literAlura.aluraChallenge.DTO.Book;
import literAlura.aluraChallenge.DTO.Result;
import literAlura.aluraChallenge.entities.Livros;
import literAlura.aluraChallenge.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
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

                if (livro.autores() == null || livro.autores().length == 0) {
                    System.out.println("Autor: Autor Desconhecido");
                    System.out.println("Ano de Morte: 0000");
                } else {
                    // Preenche com os valores dos autores
                    System.out.println("Autor: " + Arrays.stream(livro.autores())
                            .map(autor -> autor.nome() != null && !autor.nome().isEmpty() ? autor.nome() : "Autor Desconhecido")
                            .collect(Collectors.joining(",")));

                    System.out.println("Ano de Morte: " + Arrays.stream(livro.autores())
                            .map(autor -> autor.anoMorte() != 0 ? String.valueOf(autor.anoMorte()) : "0000")
                            .collect(Collectors.joining(",")));
                }

                System.out.println("Idiomas: " + String.join(", ", livro.idiomas()));
                System.out.println("Downloads: " + livro.downloads());
                System.out.println(" ");

                try {
                    Livros livroEntidade = converterParaEntidade(livro);

                    if (livroEntidade.getAutor() == null || livroEntidade.getAutor().isEmpty()) {
                        livroEntidade.setAutor("Autor Desconhecido");
                    }
                    if (livroEntidade.getAnoMorte() == 0) {
                        livroEntidade.setAnoMorte(0);
                    }

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
        boolean b = book.autores() == null || book.autores().length == 0;
        return new Livros(
                null,
                book.titulo(),
                b ? null : book.autores()[0].nome(),
                b ? 0 : book.autores()[0].anoMorte(),
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