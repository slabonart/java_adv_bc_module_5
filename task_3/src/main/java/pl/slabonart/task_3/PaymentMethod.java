package pl.slabonart.task_3;

import pl.slabonart.task_3.exception.PaymentProcessingException;
import pl.slabonart.task_3.paypal.PaymentStrategy;

public abstract class PaymentMethod {

    private final PaymentStrategy strategy;

    protected PaymentMethod(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validatePaymentDetails() {
        return strategy.validatePaymentDetails();
    }

    public void processPayment(double amount) throws PaymentProcessingException {
        strategy.processPayment(amount);
    }

}
