package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String apiKey = "395c05b5b1c43dd0e843bd80";
    String baseCurrency = "";
    String baseCurrency2 = "";

    String[] targetCurrencies = {
            "Dólar Americano =>> Peso Argentino",
            "Peso Argentino =>> Dólar Americano",
            "Real Brasileiro =>> Dólar Americano",
            "Dólar Americano =>> Real Brasileiro",
            "Dólar Americano =>> Peso colombiano",
            "Peso colombiano =>> Dólar Americano",
            "SAIR",
    };

    Scanner scanner = new Scanner(System.in);

    for (int i = 0; i < targetCurrencies.length; i++) {
      System.out.println((i + 1) + ". " + targetCurrencies[i]);
    }

    System.out.println("Escolha a moeda para conversão:");

    int choice = scanner.nextInt();

    System.out.println("Digite o valor que deseja converter:");
    double value = scanner.nextDouble();
    scanner.close();

    if (choice < 1 || choice > targetCurrencies.length) {
      System.out.println("Escolha inválida!");
      return;
    }

    String targetCurrency = targetCurrencies[choice - 1];

    if (targetCurrency.equals("SAIR")) return;

    if (targetCurrency.equals("Dólar Americano =>> Peso Argentino")) {
      baseCurrency2 = "USD";
      baseCurrency = "ARS";
    }

    if (targetCurrency.equals("Peso Argentino =>> Dólar Americano")) {
      baseCurrency = "USD";
      baseCurrency2 = "ARS";
    }

    if (targetCurrency.equals("Real Brasileiro =>> Dólar Americano")) {
      baseCurrency = "USD";
      baseCurrency2 = "BRL";
    }

    if (targetCurrency.equals("Dólar Americano =>> Real Brasileiro")) {
      baseCurrency2 = "USD";
      baseCurrency = "BRL";
    }

    if (targetCurrency.equals("Dólar Americano =>> Peso colombiano")) {
      baseCurrency2 = "USD";
      baseCurrency = "COP";
    }

    if (targetCurrency.equals("Peso colombiano =>> Dólar Americano")) {
      baseCurrency = "USD";
      baseCurrency2 = "COP";
    }

    try {
      URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency2);

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("apikey", apiKey);

      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }
      reader.close();

      Gson gson = new Gson();
      JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
      JsonObject ratesObject = jsonObject.getAsJsonObject("rates");

      String rateString = ratesObject.get(baseCurrency).getAsString();
      double rate = Double.parseDouble(rateString);

      double total = value * rate;

      System.out.printf("O valor %.2f [%s] corresponde a %.2f [%s]%n", value, baseCurrency2, total, baseCurrency);

      connection.disconnect();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (NumberFormatException e) {
      System.out.println("Erro ao converter taxa de câmbio para Double.");
      e.printStackTrace();
    }
  }
}
