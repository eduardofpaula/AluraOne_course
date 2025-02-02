package literAlura.aluraChallenge;

import literAlura.aluraChallenge.service.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraChallengeApplication implements CommandLineRunner {

	private final Principal principal;

	// Injeta o bean Principal
	public AluraChallengeApplication(Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(AluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.menu();
	}
}
