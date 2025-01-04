package literAlura.aluraChallenge.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(@JsonAlias("title") String titulo,
                   @JsonAlias("authors") Author[] autores,
                   @JsonAlias("languages") String[] idiomas,
                   @JsonAlias("download_count") int downloads){
}
