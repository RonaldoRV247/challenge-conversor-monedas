package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Conversor {
    private ConsultorMoneda consultorMoneda;
    private Scanner scanner;
    private List<RegistroConversion> historialConversiones;

    public Conversor() {
        this.consultorMoneda = new ConsultorMoneda();
        this.scanner = new Scanner(System.in);
        this.historialConversiones = new ArrayList<>();
    }

    public void exibirMenu() {
        System.out.println("*************************************************");
        System.out.println("    Sea bienvenido/a al Conversor de Moneda");
        System.out.println("*************************************************");
        System.out.println();
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileño");
        System.out.println("4) Real brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Dólar =>> Euro");
        System.out.println("8) Euro =>> Dólar");
        System.out.println("9) Dólar =>> Yen japonés");
        System.out.println("10) Yen japonés =>> Dólar");
        System.out.println("11) Dólar =>> Peso mexicano");
        System.out.println("12) Peso mexicano =>> Dólar");
        System.out.println("13) Dólar =>> Libra esterlina");
        System.out.println("14) Libra esterlina =>> Dólar");
        System.out.println("15) Dólar =>> Yuan chino");
        System.out.println("16) Yuan chino =>> Dólar");
        System.out.println("17) Dólar =>> Franco suizo");
        System.out.println("18) Franco suizo =>> Dólar");
        System.out.println("19) Ver historial de conversiones");
        System.out.println("20) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("*************************************************");
    }

    public void iniciar() {
        int opcion = 0;

        while (opcion != 20) {
            exibirMenu();
            try {
                opcion = scanner.nextInt();

                if (opcion >= 1 && opcion <= 18) {
                    realizarConversion(opcion);
                } else if (opcion == 19) {
                    mostrarHistorial();
                } else if (opcion == 20) {
                    System.out.println("¡Gracias por usar el Conversor de Monedas!");
                } else {
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }

            System.out.println();
        }
    }

    private void realizarConversion(int opcion) {
        String monedaOrigen, monedaDestino, nombreOrigen, nombreDestino;

        switch (opcion) {
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "ARS";
                nombreOrigen = "Dólares";
                nombreDestino = "Pesos argentinos";
                break;
            case 2:
                monedaOrigen = "ARS";
                monedaDestino = "USD";
                nombreOrigen = "Pesos argentinos";
                nombreDestino = "Dólares";
                break;
            case 3:
                monedaOrigen = "USD";
                monedaDestino = "BRL";
                nombreOrigen = "Dólares";
                nombreDestino = "Reales brasileños";
                break;
            case 4:
                monedaOrigen = "BRL";
                monedaDestino = "USD";
                nombreOrigen = "Reales brasileños";
                nombreDestino = "Dólares";
                break;
            case 5:
                monedaOrigen = "USD";
                monedaDestino = "COP";
                nombreOrigen = "Dólares";
                nombreDestino = "Pesos colombianos";
                break;
            case 6:
                monedaOrigen = "COP";
                monedaDestino = "USD";
                nombreOrigen = "Pesos colombianos";
                nombreDestino = "Dólares";
                break;
            case 7:
                monedaOrigen = "USD";
                monedaDestino = "EUR";
                nombreOrigen = "Dólares";
                nombreDestino = "Euros";
                break;
            case 8:
                monedaOrigen = "EUR";
                monedaDestino = "USD";
                nombreOrigen = "Euros";
                nombreDestino = "Dólares";
                break;
            case 9:
                monedaOrigen = "USD";
                monedaDestino = "JPY";
                nombreOrigen = "Dólares";
                nombreDestino = "Yenes japoneses";
                break;
            case 10:
                monedaOrigen = "JPY";
                monedaDestino = "USD";
                nombreOrigen = "Yenes japoneses";
                nombreDestino = "Dólares";
                break;
            case 11:
                monedaOrigen = "USD";
                monedaDestino = "MXN";
                nombreOrigen = "Dólares";
                nombreDestino = "Pesos mexicanos";
                break;
            case 12:
                monedaOrigen = "MXN";
                monedaDestino = "USD";
                nombreOrigen = "Pesos mexicanos";
                nombreDestino = "Dólares";
                break;
            case 13:
                monedaOrigen = "USD";
                monedaDestino = "GBP";
                nombreOrigen = "Dólares";
                nombreDestino = "Libras esterlinas";
                break;
            case 14:
                monedaOrigen = "GBP";
                monedaDestino = "USD";
                nombreOrigen = "Libras esterlinas";
                nombreDestino = "Dólares";
                break;
            case 15:
                monedaOrigen = "USD";
                monedaDestino = "CNY";
                nombreOrigen = "Dólares";
                nombreDestino = "Yuanes chinos";
                break;
            case 16:
                monedaOrigen = "CNY";
                monedaDestino = "USD";
                nombreOrigen = "Yuanes chinos";
                nombreDestino = "Dólares";
                break;
            case 17:
                monedaOrigen = "USD";
                monedaDestino = "CHF";
                nombreOrigen = "Dólares";
                nombreDestino = "Francos suizos";
                break;
            case 18:
                monedaOrigen = "CHF";
                monedaDestino = "USD";
                nombreOrigen = "Francos suizos";
                nombreDestino = "Dólares";
                break;
            default:
                return;
        }

        System.out.print("Ingrese el valor que deseas convertir: ");
        try {
            double cantidad = scanner.nextDouble();

            if (cantidad < 0) {
                System.out.println("Error: El valor debe ser positivo.");
                pausarYContinuar();
                return;
            }

            double tasa = consultorMoneda.obtenerTasaConversion(monedaOrigen, monedaDestino);

            if (tasa != -1) {
                double resultado = cantidad * tasa;
                System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n",
                    cantidad, nombreOrigen, resultado, nombreDestino);

                // Guardar en el historial
                RegistroConversion registro = new RegistroConversion(
                    monedaOrigen, monedaDestino, cantidad, resultado, tasa);
                historialConversiones.add(registro);

            } else {
                System.out.println("Error al obtener la tasa de conversión. Inténtelo de nuevo.");
            }

            pausarYContinuar();

        } catch (Exception e) {
            System.out.println("Error: Por favor ingrese un número válido.");
            scanner.nextLine(); // Limpiar buffer
            pausarYContinuar();
        }
    }

    private void mostrarHistorial() {
        System.out.println("===============================================");
        System.out.println("         HISTORIAL DE CONVERSIONES");
        System.out.println("===============================================");

        if (historialConversiones.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("Últimas " + historialConversiones.size() + " conversiones:");
            System.out.println();

            for (int i = historialConversiones.size() - 1; i >= 0; i--) {
                RegistroConversion registro = historialConversiones.get(i);
                System.out.println((historialConversiones.size() - i) + ". " + registro.obtenerResumen());
            }
        }

        pausarYContinuar();
    }

    private void pausarYContinuar() {
        System.out.println();
        System.out.print("Presione Enter para continuar...");
        try {
            scanner.nextLine(); // Consumir cualquier entrada pendiente
            scanner.nextLine(); // Esperar Enter del usuario
        } catch (Exception e) {
            // Si hay algún problema, simplemente continúa
        }
        System.out.println();
    }
}
