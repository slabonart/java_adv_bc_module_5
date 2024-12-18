package pl.slabonart.task_3.paypal;

import pl.slabonart.task_3.PaymentMethod;

public class PayPalPayment extends PaymentMethod {

    public PayPalPayment(PaymentStrategy strategy) {
        super(strategy);
    }
}

