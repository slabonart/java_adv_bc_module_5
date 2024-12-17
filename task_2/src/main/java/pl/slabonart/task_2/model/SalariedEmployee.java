package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;

public class SalariedEmployee extends Employee {

    public SalariedEmployee(String name) {
        this.name = name;
    }

    @Override
    public Money calculatePay() {
        return Money.of(BigDecimal.valueOf(12000), "PLN");
    }

    @Override
    public Money calculateBonus() {
        return Money.of(BigDecimal.valueOf(0), "PLN");
    }

    @Override
    public String getType() {
        return "SALARIED";
    }

}
