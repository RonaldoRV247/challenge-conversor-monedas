package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidadOriginal;
    private double cantidadConvertida;
    private double tasaUsada;
    private LocalDateTime fechaHora;

    public RegistroConversion(String monedaOrigen, String monedaDestino,
                             double cantidadOriginal, double cantidadConvertida,
                             double tasaUsada) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.cantidadOriginal = cantidadOriginal;
        this.cantidadConvertida = cantidadConvertida;
        this.tasaUsada = tasaUsada;
        this.fechaHora = LocalDateTime.now();
    }

    public String obtenerResumen() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %.2f %s → %.2f %s (Tasa: %.4f)",
                fechaHora.format(formatter),
                cantidadOriginal, monedaOrigen,
                cantidadConvertida, monedaDestino,
                tasaUsada);
    }

    // Getters
    public String getMonedaOrigen() { return monedaOrigen; }
    public String getMonedaDestino() { return monedaDestino; }
    public double getCantidadOriginal() { return cantidadOriginal; }
    public double getCantidadConvertida() { return cantidadConvertida; }
    public double getTasaUsada() { return tasaUsada; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}
