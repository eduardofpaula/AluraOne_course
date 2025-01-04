package literAlura.aluraChallenge.entities;

import jakarta.persistence.*;
import literAlura.aluraChallenge.DTO.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livro",schema = "literalura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro", nullable = false)
    private Long idLivro;

    @Column(name = "titulo", nullable = false, length = 300)
    private String nome;

    @Column(name = "nome_autor", nullable = false, length = 300)
    private String autor;

    @Column(name = "ano_morte", nullable = false)
    private int anoMorte;

    @Column(name = "idioma",nullable = false, length = 5)
    private String idioma;

    @Column(name = "num_downloads", nullable = false)
    private int numDownloads;

}
