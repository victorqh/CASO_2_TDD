package com.example.caso2.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();

        // Si todavia no ha llegado su cumpleanios este anio, resta un anio.
        boolean yaCumplio = fechaActual.getMonthValue() > fechaNacimiento.getMonthValue()
                || (fechaActual.getMonthValue() == fechaNacimiento.getMonthValue()
                        && fechaActual.getDayOfMonth() >= fechaNacimiento.getDayOfMonth());

        return yaCumplio ? edad : edad - 1;
    }
}
