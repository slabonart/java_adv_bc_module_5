package pl.slabonart.task_3.creditcard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.slabonart.task_3.paypal.PaymentStrategy;
import pl.slabonart.task_3.exception.PaymentProcessingException;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    private static final Logger log = LoggerFactory.getLogger(CreditCardPaymentStrategy.class);

    @Override
    public boolean validatePaymentDetails() {
        // implement validation process
        return true;
    }

    @Override
    public void processPayment(double amount) throws PaymentProcessingException {
        log.info("Processing credit card payment: ${}", amount);
    }
}