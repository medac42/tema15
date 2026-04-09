package entornos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraRiesgoTest {
    CalculadoraRiesgo calc = new CalculadoraRiesgo();

    @Test
    void testEdadNegativa() {
        assertEquals("Error", calc.evaluarEdad(-5));
    }

    @Test
    void testAdulto() {
        assertEquals("Adulto", calc.evaluarEdad(25));
    }
    
    @Test
    void testSenior() {
        // Test para el caso Senior (mayor de 65)
        assertEquals("Senior", calc.evaluarEdad(70));
    }

    @Test
    void testLimite18() {
        // Test para el límite exacto de 18 años
        assertEquals("Adulto", calc.evaluarEdad(18));
    }

    @Test
    void testJoven() {
        assertEquals("Joven", calc.evaluarEdad(17));
    }

    @Test
    void testErrorSuperior() {
        assertEquals("Error", calc.evaluarEdad(121));
    }
}
