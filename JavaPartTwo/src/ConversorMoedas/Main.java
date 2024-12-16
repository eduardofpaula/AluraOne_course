package ConversorMoedas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        int escolha = 0;
        while (escolha != 7) {
            System.out.println("***************************************************");
            System.out.println("Seja Bem Vindo ao Conversor de Moedas!");
            System.out.println("***************************************************");

            menuConversor();

            System.out.println("");
            System.out.println("Digite a opção desejada: ");
            escolha = sc.nextInt();

            if (escolha == 11) {
                System.out.println("Obrigado por utilizar o Conversor de Moedas!");
                break;
            }

            System.out.println("Digite a quantidade de dinheiro que deseja converter: ");
            double quantidade = sc.nextDouble();
            if (quantidade <= 0) {
                System.out.println("Digite um valor válido!");
                continue;
            }

            Moeda moedaBase = null;
            Moeda moedaFinal = null;
            switch (escolha) {
                case 1 -> {
                    moedaBase = Moeda.USD;
                    moedaFinal = Moeda.ARS;
                }
                case 2 -> {
                    moedaBase = Moeda.ARS;
                    moedaFinal = Moeda.USD;
                }
                case 3 -> {
                    moedaBase = Moeda.BRL;
                    moedaFinal = Moeda.COP;
                }
                case 4 -> {
                    moedaBase = Moeda.COP;
                    moedaFinal = Moeda.BRL;
                }
                case 5 -> {
                    moedaBase = Moeda.EUR;
                    moedaFinal = Moeda.GBP;
                }
                case 6 -> {
                    moedaBase = Moeda.GBP;
                    moedaFinal = Moeda.EUR;
                }
                case 7 -> {
                    moedaBase = Moeda.JPY;
                    moedaFinal = Moeda.CHF;
                }
                case 8 -> {
                    moedaBase = Moeda.CHF;
                    moedaFinal = Moeda.JPY;
                }
                case 9 -> {
                    moedaBase = Moeda.AUD;
                    moedaFinal = Moeda.CAD;
                }
                case 10 -> {
                    moedaBase = Moeda.CAD;
                    moedaFinal = Moeda.AUD;
                }
                default -> {
                    System.out.println("Opção inválida!");
                    return;
                }
            }

            String endereco = "https://v6.exchangerate-api.com/v6/2ed16794da82f77e91fb7215/pair/" + moedaBase + "/" + moedaFinal + "/" + quantidade;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ConversorResponse conversorResponse = gson.fromJson(response.body(), ConversorResponse.class);
            System.out.println("Valor de conversão " + quantidade + " [" + conversorResponse.base_code() + "] " + "corresponde ao valor final de " + conversorResponse.conversion_result() + " [" + conversorResponse.target_code() + "]");

        }
    }

    public static void menuConversor() {
        System.out.println("1 - Dolar --->>> Peso Argentino");
        System.out.println("2 - Peso Argentino --->>> Dolar");
        System.out.println("3 - Real Brasileiro --->>> Peso Colombiano");
        System.out.println("4 - Peso Colombiano --->>> Real Brasileiro");
        System.out.println("5 - Euro --->>> Libra Esterlina");
        System.out.println("6 - Libra Esterlina --->>> Euro");
        System.out.println("7 - Iene --->>> Franco Suíço");
        System.out.println("8 - Franco Suíço --->>> Iene");
        System.out.println("9 - Dólar Australiano --->>> Dólar Canadense");
        System.out.println("10 - Dólar Canadense --->>> Dólar Australiano");
        System.out.println("11 - Sair");
    }
}
