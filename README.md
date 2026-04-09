# Práctica: Pruebas Unitarias con JUnit 5 en VS Code

Este proyecto contiene la resolución de la práctica de pruebas unitarias para la asignatura de Entornos de Desarrollo.

## Paso a paso realizado

1.  **Configuración del entorno**: He utilizado el asistente de Visual Studio Code (`F1` -> `Java: Create Java Project`) eligiendo **Maven** y el arquetipo `maven-archetype-quickstart`. He configurado el `GroupId` como `entornos` y el `ArtifactId` como `test-vscode`.
2.  **Configuración de dependencias**: En el archivo `pom.xml`, he actualizado la sección de `<dependencies>` para incluir **JUnit 5 (Jupiter API)**. También he añadido el motor de ejecución (`junit-jupiter-engine`) y el plugin `maven-surefire-plugin` para asegurar que los tests se ejecuten correctamente desde la línea de comandos y el editor.
3.  **Implementación del código**: He creado la clase `CalculadoraRiesgo` en `src/main/java/entornos/` con la lógica de clasificación por edades pedida.
4.  **Nueva Interfaz Visual**: He añadido una interfaz profesional utilizando **Swing** y la librería **FlatLaf** para conseguir un acabado moderno (tipo Google/Material Design). La clase principal es `InterfazCalculadora.java`.
5.  **Desarrollo de las pruebas**: En `src/test/java/entornos/CalculadoraRiesgoTest.java`, he implementado:
    *   `testEdadNegativa`: Valida que edades menores a 0 devuelvan "Error".
    *   `testAdulto`: Valida el rango intermedio.
    *   `testSenior`: **(Nuevo)** Valida que una edad de 70 devuelva "Senior".
    *   `testLimite18`: **(Nuevo)** Valida que el límite exacto de 18 años sea clasificado como "Adulto".
    *   Tests adicionales para límites superiores y casos de borde.

## Uso de la interfaz de VS Code

Para esta práctica se han utilizado las siguientes herramientas de VS Code:
*   **Testing Explorer (El Matraz)**: Para visualizar y ejecutar la suite de pruebas completa de forma gráfica.
*   **CodeLens (Run | Debug)**: Para ejecutar tests individuales directamente sobre el código.
*   **Depuración**: Se han colocado puntos de interrupción (breakpoints) en `CalculadoraRiesgo.java` para inspeccionar el flujo de ejecución durante el proceso de `Debug`.

## Cómo Ejecutar la Interfaz
Para ver la interfaz visual:
1. Asegúrate de que las dependencias de Maven se han descargado (VS Code lo hace automáticamente al abrir el `pom.xml`).
2. Abre `src/main/java/entornos/InterfazCalculadora.java`.
3. Pulsa `F5` o haz clic en el botón **Run** que aparece sobre el método `main`.

## Captura de Ejecución

![Captura de tests en VS Code](captura_tests.png)
*(Nota: Aquí se debe incluir la captura de pantalla del Testing Explorer con todos los tests en verde).*
