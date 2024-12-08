package pl.slabonart;

public class PaymentProcessor {

    public void makePayment(PaymentMethod payment, double amount) {
        if (payment.validatePaymentDetails()) {
            payment.processPayment(amount);
        }
    }
}

