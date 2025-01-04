package literAlura.aluraChallenge.repository;

import literAlura.aluraChallenge.entities.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {

    @Query("SELECT l.autor, l.anoMorte FROM Livros l WHERE l.anoMorte = :ano")
    List<Object[]> autoresVivos(int ano);

    @Query("SELECT l.nome, l.idioma FROM Livros l WHERE l.idioma = :idioma")
    List<Object[]> findLivrosByIdioma(String idioma);
}
