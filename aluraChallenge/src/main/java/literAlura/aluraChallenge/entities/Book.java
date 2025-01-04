package literAlura.aluraChallenge.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(@JsonAlias("title") String titulo,
                   @JsonAlias("authors") String[] autores,
                   @JsonAlias("languages") String[] idiomas,
                   @JsonAlias("download_count") int downloads){
}
