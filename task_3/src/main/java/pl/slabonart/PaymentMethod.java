package pl.slabonart;

abstract class PaymentMethod {

    abstract boolean validatePaymentDetails();
    abstract void processPayment(double amount);

}
