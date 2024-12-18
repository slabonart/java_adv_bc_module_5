package pl.slabonart.task_3.paypal;

import pl.slabonart.task_3.exception.PaymentProcessingException;

public interface PaymentStrategy {

    boolean validatePaymentDetails();

    void processPayment(double amount) throws PaymentProcessingException;

}
