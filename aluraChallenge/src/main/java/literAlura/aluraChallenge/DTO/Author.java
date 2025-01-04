package literAlura.aluraChallenge.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Author(@JsonAlias("name") String nome,
                     @JsonAlias("death_year") int anoMorte) {
}
