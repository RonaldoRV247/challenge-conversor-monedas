# 💱 Conversor de Monedas - Challenge

Una aplicación Java completa para convertir entre diferentes monedas utilizando tasas de cambio en tiempo real.

## 🌟 Características

- **18 opciones de conversión** entre 9 monedas populares
- **Tasas de cambio en tiempo real** mediante API REST
- **Historial de conversiones** con marcas de tiempo
- **Interfaz intuitiva** por consola
- **Validación robusta** de entradas
- **Experiencia de usuario optimizada** con pausas entre operaciones

## 💰 Monedas Soportadas

| Código | Moneda | País/Región |
|--------|--------|-------------|
| USD | Dólar estadounidense | Estados Unidos |
| EUR | Euro | Eurozona |
| ARS | Peso argentino | Argentina |
| BRL | Real brasileño | Brasil |
| COP | Peso colombiano | Colombia |
| JPY | Yen japonés | Japón |
| MXN | Peso mexicano | México |
| GBP | Libra esterlina | Reino Unido |
| CNY | Yuan chino | China |
| CHF | Franco suizo | Suiza |

## 🚀 Cómo usar la aplicación

### 1. Ejecutar la aplicación
```bash
java -jar conversor-monedas.jar
```

### 2. Seleccionar conversión
La aplicación te mostrará un menú con 20 opciones:
- **Opciones 1-18**: Conversiones entre diferentes monedas
- **Opción 19**: Ver historial de conversiones
- **Opción 20**: Salir

### 3. Ingresar cantidad
Introduce la cantidad que deseas convertir (solo números positivos).

### 4. Ver resultado
La aplicación mostrará:
- Cantidad original y moneda
- Cantidad convertida y moneda destino
- El resultado se guardará automáticamente en el historial

### 5. Continuar o salir
Presiona Enter para volver al menú principal.

## 📊 Ejemplo de uso

```
*************************************************
    Sea bienvenido/a al Conversor de Moneda
*************************************************

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
...
19) Ver historial de conversiones
20) Salir
Elija una opción válida:
*************************************************

> 1
Ingrese el valor que deseas convertir: 100
El valor 100.00 [Dólares] corresponde al valor final de =>>> 136183.00 [Pesos argentinos]

Presione Enter para continuar...
```

## 📈 Historial de Conversiones

La aplicación mantiene un registro completo de todas tus conversiones:

```
===============================================
         HISTORIAL DE CONVERSIONES
===============================================
Últimas 3 conversiones:

1. [04/08/2025 15:30:45] 100.00 USD → 136183.00 ARS (Tasa: 1361.8300)
2. [04/08/2025 15:28:22] 50.00 USD → 277.25 BRL (Tasa: 5.5450)
3. [04/08/2025 15:25:10] 200.00 EUR → 231.20 USD (Tasa: 1.1560)
```

## 🛠️ Tecnologías utilizadas

- **Java 17**: Lenguaje de programación principal
- **Maven**: Gestión de dependencias y construcción
- **GSON**: Procesamiento de datos JSON
- **HttpClient**: Comunicación con APIs REST
- **ExchangeRate-API**: Fuente de tasas de cambio en tiempo real

## 🏗️ Arquitectura del proyecto

```
src/main/java/org/example/
├── Main.java              # Punto de entrada de la aplicación
├── Conversor.java         # Lógica principal y menú de usuario
├── ConsultorMoneda.java   # Comunicación con la API de tasas
└── RegistroConversion.java # Modelo para el historial
```

### Componentes principales:

- **Main**: Inicializa la aplicación
- **Conversor**: Maneja la interfaz de usuario y lógica de conversión
- **ConsultorMoneda**: Realiza peticiones HTTP a la API de tasas de cambio
- **RegistroConversion**: Almacena información de cada conversión con timestamp

## 🔧 Requisitos del sistema

- **Java 17** o superior
- **Conexión a Internet** (para obtener tasas actualizadas)
- **Maven** (para compilación desde código fuente)

## 📦 Instalación y ejecución

### Desde código fuente:
```bash
git clone https://github.com/RonaldoRV247/challenge-conversor-monedas.git
cd challenge-conversor-monedas
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Desde IntelliJ IDEA:
1. Abrir el proyecto
2. Ejecutar la clase `Main.java`

## 🌐 API utilizada

Este proyecto utiliza [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio actualizadas en tiempo real.

## ✨ Características avanzadas

- **Validación de entrada**: Previene errores de formato y valores negativos
- **Manejo de errores**: Gestiona problemas de conectividad y respuestas de API
- **Experiencia optimizada**: Pausas entre operaciones para mejor legibilidad
- **Historial persistente**: Mantiene registro durante toda la sesión
- **Interfaz clara**: Menú intuitivo y resultados bien formateados

## 🎯 Funcionalidades implementadas

### ✅ Fases del desafío completadas:
- **Fase 4**: HttpClient para solicitudes HTTP
- **Fase 5**: HttpRequest para configuración de peticiones
- **Fase 6**: HttpResponse para manejo de respuestas
- **Fase 7**: Análisis JSON con GSON
- **Fase 8**: Filtrado de monedas específicas
- **Fase 9**: Lógica de conversión matemática
- **Fase 10**: Interfaz de usuario por consola

### 🚀 Extras implementados:
- **Historial de conversiones** con marcas de tiempo
- **Soporte extendido** para más monedas (9 monedas, 18 conversiones)
- **Registros detallados** usando java.time
- **Experiencia de usuario mejorada** con pausas

## 👨‍💻 Autor

Desarrollado por **Ronaldo RV** como parte del Challenge de Conversor de Monedas.

---

⭐ **¡No olvides dar una estrella al proyecto si te resultó útil!**
