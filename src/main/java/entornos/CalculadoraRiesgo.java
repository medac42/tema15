package entornos;

public class CalculadoraRiesgo {
    public String evaluarEdad(int edad) {
        if (edad < 0 || edad > 120) return "Error";
        if (edad < 18) return "Joven";
        if (edad <= 65) return "Adulto";
        return "Senior";
    }
}
