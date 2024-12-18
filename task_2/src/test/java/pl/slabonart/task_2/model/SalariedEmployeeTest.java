package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalariedEmployeeTest {

    private final Employee employee = new SalariedEmployee("John");

    @Test
    void whenCalculatePay_thenReturnProperValue() {
        assertEquals(Money.of(12000, "PLN"), employee.calculatePay());
    }

    @Test
    void whenCalculateBonus_thenReturnProperValue() {
        assertEquals(Money.of(0, "PLN"), employee.calculateBonus());
    }

    @Test
    void whenGetType_thenReturnProperValue() {
        assertEquals("SALARIED", employee.getType());
    }
}