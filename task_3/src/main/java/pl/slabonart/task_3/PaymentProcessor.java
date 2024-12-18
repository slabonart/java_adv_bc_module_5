package pl.slabonart.task_3;

import pl.slabonart.task_3.exception.PaymentProcessingException;

public class PaymentProcessor {

    public void makePayment(PaymentMethod payment, double amount) throws PaymentProcessingException {
        if (payment.validatePaymentDetails()) {
            payment.processPayment(amount);
        }
    }
}

