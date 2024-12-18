package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;

public class HourlyEmployee extends Employee {

    public HourlyEmployee(String name) {
        this.name = name;
    }

    @Override
    public Money calculatePay() {
        return Money.of(BigDecimal.valueOf(11000), "PLN", Money.DEFAULT_MONETARY_CONTEXT);
    }

    @Override
    public Money calculateBonus() {
        return Money.of(BigDecimal.valueOf(1100), "PLN", Money.DEFAULT_MONETARY_CONTEXT);
    }

    @Override
    public String getType() {
        return "HOURLY";
    }
}
