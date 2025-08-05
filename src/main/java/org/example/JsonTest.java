package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonTest {
    public static void main(String[] args) {
        try {
            // Crear instancia de Gson
            Gson gson = new Gson();

            // Ejemplo de JSON string
            String jsonString = "{\"nombre\":\"Juan\",\"edad\":25,\"ciudad\":\"Madrid\"}";

            // Parsear JSON usando Gson
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            // Leer valores del JSON
            String nombre = jsonObject.get("nombre").getAsString();
            int edad = jsonObject.get("edad").getAsInt();
            String ciudad = jsonObject.get("ciudad").getAsString();

            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Ciudad: " + ciudad);

            System.out.println("¡GSON funciona correctamente!");

            // Ejemplo adicional: convertir objeto Java a JSON
            Persona persona = new Persona("Maria", 30, "Barcelona");
            String jsonPersona = gson.toJson(persona);
            System.out.println("Objeto convertido a JSON: " + jsonPersona);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Clase auxiliar para demostrar conversión de objetos
class Persona {
    private String nombre;
    private int edad;
    private String ciudad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters necesarios para Gson
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }
}
