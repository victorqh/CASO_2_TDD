package com.example.caso2.edad;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraEdadTest {

    @Test
    void test_edad_cuando_ya_cumplio_anios_este_anio() {
        LocalDate nacimiento = LocalDate.of(2000, 5, 15);
        LocalDate hoy = LocalDate.of(2026, 9, 30);

        int edad = CalculadoraEdad.calcularEdad(nacimiento, hoy);

        assertEquals(26, edad);
    }

    @Test
    void test_edad_cuando_aun_no_cumple_anios_este_anio() {
        LocalDate nacimiento = LocalDate.of(2000, 12, 10);
        LocalDate hoy = LocalDate.of(2026, 9, 30);

        int edad = CalculadoraEdad.calcularEdad(nacimiento, hoy);

        assertEquals(25, edad);
    }

    @Test
    void test_edad_el_dia_del_cumpleanios() {
        LocalDate nacimiento = LocalDate.of(2000, 9, 30);
        LocalDate hoy = LocalDate.of(2026, 9, 30);

        int edad = CalculadoraEdad.calcularEdad(nacimiento, hoy);

        assertEquals(26, edad);
    }

    @Test
    void test_fecha_nacimiento_futura_lanza_excepcion() {
        LocalDate nacimiento = LocalDate.of(2027, 1, 1);
        LocalDate hoy = LocalDate.of(2026, 9, 30);

        IllegalArgumentException excepcion = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraEdad.calcularEdad(nacimiento, hoy));

        assertEquals("La fecha de nacimiento no puede ser posterior a la fecha actual",
                excepcion.getMessage());
    }

    @Test
    void test_bisiesto_un_dia_antes_del_cumpleanios() {
        LocalDate nacimiento = LocalDate.of(2004, 2, 29);
        LocalDate hoy = LocalDate.of(2025, 2, 28);

        int edad = CalculadoraEdad.calcularEdad(nacimiento, hoy);

        assertEquals(20, edad);
    }

    @Test
    void test_bisiesto_cumple_el_1_de_marzo() {
        LocalDate nacimiento = LocalDate.of(2004, 2, 29);
        LocalDate hoy = LocalDate.of(2025, 3, 1);

        int edad = CalculadoraEdad.calcularEdad(nacimiento, hoy);

        assertEquals(21, edad);
    }

    @Test
    void test_bisiesto_en_anio_bisiesto() {
        LocalDate nacimiento = LocalDate.of(2004, 2, 29);
        LocalDate hoy = LocalDate.of(2028, 2, 29);

        int edad = CalculadoraEdad.calcularEdad(nacimiento, hoy);

        assertEquals(24, edad);
    }
}
