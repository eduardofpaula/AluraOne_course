package alura.spring.springAluraOne;

import alura.spring.springAluraOne.entities.Tarefa;
import alura.spring.springAluraOne.service.ConsumoApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class SpringAluraOneApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringAluraOneApplication.class, args);
    }

//    @Override
//	public void run(String... args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Digite um numero e ira aparecer a contagem até ele: ");
//		int numero = sc.nextInt();
//		ConsumoApi contador = new ConsumoApi();
//		contador.contador(numero);
//	}

//    @Override
//    public void run(String... args) throws Exception {
//        // instancia o objeto tarefa
//        Tarefa tarefa = new Tarefa("assistir aula 1", false, "João");
//        // cria o mapper
//        ObjectMapper objectMapper = new ObjectMapper();
//        // grava o objeto tarefa no arquivo tarefa.json
//        objectMapper.writeValue(new File("tarefa.json"), tarefa);
//        System.out.println("Dados salvos no arquivo tarefa.json!");
//    }

//    @Override
//    public void run(String... args) throws Exception {
//        // cria o mapper
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Tarefa tarefaLida = objectMapper.readValue((new File("tarefa.json")), Tarefa.class);
//
//        System.out.println("conteudo do arquivo tarefas: " + tarefaLida);
//    }

	// Serializando um objeto para JSON
//	@Override
//	public void run(String... args) throws Exception {
//		Tarefa tarefa = new Tarefa("assistir aula 1", false, "João");
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(new File("tarefa.json"), tarefa);
//		System.out.println("Dados salvos no arquivo tarefa.json!");
//	}

	// Deserializando um JSON para um objeto
	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Tarefa tarefaLida = objectMapper.readValue(new File("tarefa.json"), Tarefa.class);
		System.out.println("conteudo do arquivo tarefas: " + tarefaLida);
	}
}
