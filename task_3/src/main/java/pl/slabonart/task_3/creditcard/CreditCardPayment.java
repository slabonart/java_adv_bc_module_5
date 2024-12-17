package pl.slabonart.task_3.creditcard;

import pl.slabonart.task_3.PaymentMethod;
import pl.slabonart.task_3.paypal.PaymentStrategy;

public class CreditCardPayment extends PaymentMethod {

    public CreditCardPayment() {
        super(new CreditCardPaymentStrategy());
    }

    public CreditCardPayment(PaymentStrategy strategy) {
        super(strategy);
    }
}

