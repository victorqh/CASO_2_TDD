package com.example.caso2.edad;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
