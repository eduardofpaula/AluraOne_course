package alura.spring.springAluraOne.service;

import alura.spring.springAluraOne.entities.Tarefa;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public void contador(int numero){
        for (int i = 1; i <= numero;i++){
            System.out.println(i);
        }
    }

    // Jackson é uma biblioteca para serializar e deserializar objetos Java em JSON e vice-versa.
    public void gravarJson(Tarefa tarefa, File file) {
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.writeValue(file, tarefa);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
