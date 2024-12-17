package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    private final Employee employee = new HourlyEmployee("John");

    @Test
    void whenCalculatePay_thenReturnProperValue() {
        assertEquals(Money.of(11000, "PLN"), employee.calculatePay());
    }

    @Test
    void whenCalculateBonus_thenReturnProperValue() {
        assertEquals(Money.of(1100, "PLN"), employee.calculateBonus());
    }

    @Test
    void whenGetType_thenReturnProperValue() {
        assertEquals("HOURLY", employee.getType());
    }
}