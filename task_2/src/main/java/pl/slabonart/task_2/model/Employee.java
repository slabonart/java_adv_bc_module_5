package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;

public abstract class Employee {

    protected String name;

    protected String type;

    public abstract Money calculatePay();

    public abstract Money calculateBonus();

    public abstract String getType();

    public String getName() {
        return name;
    }
}
