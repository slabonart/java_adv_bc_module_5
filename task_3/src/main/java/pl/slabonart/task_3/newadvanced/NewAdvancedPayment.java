package pl.slabonart.task_3.newadvanced;

import pl.slabonart.task_3.PaymentMethod;
import pl.slabonart.task_3.paypal.PaymentStrategy;

public class NewAdvancedPayment extends PaymentMethod {

    public NewAdvancedPayment(PaymentStrategy strategy) {
        super(strategy);
    }

    public NewAdvancedPayment() {
        super(new NewAdvancedPaymentStrategy());
    }
}
