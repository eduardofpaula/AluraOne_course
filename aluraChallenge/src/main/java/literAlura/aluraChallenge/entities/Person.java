package literAlura.aluraChallenge.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(@JsonAlias("name") String nome,
                     @JsonAlias("death_year") int anoMorte) {
}
