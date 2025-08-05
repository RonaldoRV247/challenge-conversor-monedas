package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultorMoneda {
    private static final String API_KEY = "bf16cf01a4f74b6874d5d6c9";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private HttpClient client;
    private Gson gson;

    public ConsultorMoneda() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public JsonObject obtenerTasasCambio(String monedaBase) {
        try {
            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + monedaBase))
                    .GET()
                    .build();

            // Enviar la solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Verificar código de estado
            if (response.statusCode() == 200) {
                // Parsear respuesta JSON
                JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
                return jsonResponse;
            } else {
                System.out.println("Error en la API: Código " + response.statusCode());
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }

    public double obtenerTasaConversion(String monedaOrigen, String monedaDestino) {
        JsonObject respuesta = obtenerTasasCambio(monedaOrigen);

        if (respuesta != null && respuesta.has("conversion_rates")) {
            JsonObject tasas = respuesta.getAsJsonObject("conversion_rates");

            if (tasas.has(monedaDestino)) {
                return tasas.get(monedaDestino).getAsDouble();
            }
        }

        return -1; // Error
    }
}
