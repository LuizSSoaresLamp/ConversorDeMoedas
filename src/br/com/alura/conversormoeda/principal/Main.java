package br.com.alura.conversormoeda.principal;

import br.com.alura.conversormoeda.modelos.Conversões;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String baseCode = "";
        String targetCode = "";


        Scanner opcao = new Scanner(System.in);
        System.out.println("Escolha a conversão desejada:\n" +
                " 1 - Real(BRL) para Dólar Americano(USD)\n" +
                " 2 - Dólar Americano(USD para Real(BRL)\n" +
                " 3 - Real(BRL) para Peso Argentino(ARS)\n" +
                " 4 - Peso Argentino(ARS) para Real(BRL)\n" +
                " 5 - Real(BRL) para Peso Chileno(CLP)\n" +
                " 6 - Peso Chileno(CLP) para Real(BRL)\n" +
                " 7 - sair ");
        //Aqui é guardado o valor referente a opção escolhida.
        int guardaOpcao = opcao.nextInt();

        //Aqui ele pega a opção digitada e joga a moeda base e a moeda alvo dentro do endereco para fazeer a requisicao da Api.
        switch (guardaOpcao) {
            case 1:
                baseCode = "BRL";
                targetCode = "USD";
                break;
            case 2:
                baseCode = "USD";
                targetCode = "BRL";
                break;
            case 3:
                baseCode = "BRL";
                targetCode = "ARS";
                break;
            case 4:
                baseCode = "ARS";
                targetCode = "BRL";
                break;
            case 5:
                baseCode = "BRL";
                targetCode = "CLP";
                break;
            case 6:
                baseCode = "CLP";
                targetCode = "BRL";
                break;
            case 7:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Escolha inválida.");
                System.exit(0);
        }

        String endereco = "https://v6.exchangerate-api.com/v6/5edc63a7b0795988588c7153/pair/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco + baseCode + "/" + targetCode))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Conversões responseObj = gson.fromJson(json, Conversões.class);
        Conversões conversoes = new Conversões();

        Scanner valor = new Scanner(System.in);
        System.out.println("Agora escolha quanto você quer converter: ");
        double guardaValor = valor.nextDouble();

        //Aqui ele pega a opção informada e decide o que será impresso de acordo com o que foi escolhido.
        if (guardaOpcao != 7) {
            System.out.println("O resultado do valor: " + guardaValor + " para a conversão de " + baseCode + " para " + targetCode + " é " + conversoes.calculateConversionResult(guardaValor, responseObj.getConversion_rate()));
      


    }
}
}
