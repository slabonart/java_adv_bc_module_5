package pl.slabonart.task_3.newadvanced;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.slabonart.task_3.exception.PaymentProcessingException;
import pl.slabonart.task_3.paypal.PaymentStrategy;

public class NewAdvancedPaymentStrategy implements PaymentStrategy {

    private static final Logger log = LoggerFactory.getLogger(NewAdvancedPaymentStrategy.class);

    @Override
    public boolean validatePaymentDetails() {
        // implement validation process
        return true;
    }

    @Override
    public void processPayment(double amount) throws PaymentProcessingException {
        log.info("Processing new advanced payment: ${}", amount);
    }
}
