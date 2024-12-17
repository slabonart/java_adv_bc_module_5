package pl.slabonart.task_2.model;

import org.javamoney.moneta.Money;

public interface EmployeeInt {

    Money calculatePay();

    Money calculateBonus();

    String getType();

    String getName();

}
