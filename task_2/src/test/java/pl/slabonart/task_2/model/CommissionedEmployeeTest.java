package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CommissionedEmployeeTest {

    private final Employee employee = new CommissionedEmployee("John");

    @Test
    void whenCalculatePay_thenReturnProperValue() {
        assertEquals(Money.of(10000, "PLN"), employee.calculatePay());
    }

    @Test
    void whenCalculateBonus_thenReturnProperValue() {
        assertEquals(Money.of(100, "PLN"), employee.calculateBonus());
    }

    @Test
    void whenGetType_thenReturnProperValue() {
        assertEquals("COMMISSIONED", employee.getType());
    }
}