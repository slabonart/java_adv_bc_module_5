package pl.slabonart.task_3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.slabonart.task_3.creditcard.CreditCardPayment;
import pl.slabonart.task_3.creditcard.CreditCardPaymentStrategy;
import pl.slabonart.task_3.exception.PaymentProcessingException;
import pl.slabonart.task_3.newadvanced.NewAdvancedPayment;
import pl.slabonart.task_3.newadvanced.NewAdvancedPaymentStrategy;
import pl.slabonart.task_3.paypal.PayPalPayment;
import pl.slabonart.task_3.paypal.PayPalPaymentStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentProcessorTest {

    private static final String TEST_EXCEPTION_MESSAGE = "test_message";
    private static final double PAYMENT_AMOUNT = 100.0;

    @Mock
    PayPalPaymentStrategy payPalPaymentStrategy;

    @Mock
    CreditCardPaymentStrategy creditCardPaymentStrategy;

    @Mock
    NewAdvancedPaymentStrategy newAdvancedPaymentStrategy;

    PaymentProcessor processor = new PaymentProcessor();

    @Test
    void whenCreditCardPaymentIsValid_thenProcessPayment() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new CreditCardPayment(creditCardPaymentStrategy);
        when(creditCardPaymentStrategy.validatePaymentDetails()).thenReturn(true);

        processor.makePayment(paymentMethod, PAYMENT_AMOUNT);

        verify(creditCardPaymentStrategy, times(1)).processPayment(PAYMENT_AMOUNT);
    }

    @Test
    void whenCreditCardPaymentIsNotValid_thenDoNotProcessPayment() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new CreditCardPayment(creditCardPaymentStrategy);
        when(creditCardPaymentStrategy.validatePaymentDetails()).thenReturn(false);

        processor.makePayment(paymentMethod, PAYMENT_AMOUNT);

        verify(creditCardPaymentStrategy, times(0)).processPayment(PAYMENT_AMOUNT);
    }

    @Test
    void whenPayPalPaymentIsValid_thenProcessPayment() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new PayPalPayment(payPalPaymentStrategy);
        when(payPalPaymentStrategy.validatePaymentDetails()).thenReturn(true);

        processor.makePayment(paymentMethod, PAYMENT_AMOUNT);

        verify(payPalPaymentStrategy, times(1)).processPayment(PAYMENT_AMOUNT);
    }

    @Test
    void whenPayPalPaymentIsNotValid_thenDoNotProcessPayment() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new PayPalPayment(payPalPaymentStrategy);
        when(payPalPaymentStrategy.validatePaymentDetails()).thenReturn(false);

        processor.makePayment(paymentMethod, PAYMENT_AMOUNT);

        verify(payPalPaymentStrategy, times(0)).processPayment(PAYMENT_AMOUNT);
    }

    @Test
    void whenNewAdvancedPaymentIsValid_thenProcessPayment() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new NewAdvancedPayment(newAdvancedPaymentStrategy);
        when(newAdvancedPaymentStrategy.validatePaymentDetails()).thenReturn(true);

        processor.makePayment(paymentMethod, PAYMENT_AMOUNT);

        verify(newAdvancedPaymentStrategy, times(1)).processPayment(PAYMENT_AMOUNT);
    }

    @Test
    void whenNewAdvancedPaymentIsNotValid_thenDoNotProcessPayment() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new PayPalPayment(newAdvancedPaymentStrategy);
        when(newAdvancedPaymentStrategy.validatePaymentDetails()).thenReturn(false);

        processor.makePayment(paymentMethod, PAYMENT_AMOUNT);

        verify(newAdvancedPaymentStrategy, times(0)).processPayment(PAYMENT_AMOUNT);
    }

    @Test
    void whenCreditCardPaymentProcessFail_thenThrowException() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new CreditCardPayment(creditCardPaymentStrategy);
        when(creditCardPaymentStrategy.validatePaymentDetails()).thenReturn(true);
        doThrow(new PaymentProcessingException(TEST_EXCEPTION_MESSAGE)).when(creditCardPaymentStrategy).processPayment(anyDouble());

        Exception thrown = assertThrows(Exception.class, () -> processor.makePayment(paymentMethod, PAYMENT_AMOUNT));

        assertInstanceOf(PaymentProcessingException.class, thrown);
        assertEquals(TEST_EXCEPTION_MESSAGE, thrown.getMessage());
    }

    @Test
    void whenPayPalPaymentProcessFail_thenThrowException() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new PayPalPayment(payPalPaymentStrategy);
        when(payPalPaymentStrategy.validatePaymentDetails()).thenReturn(true);
        doThrow(new PaymentProcessingException(TEST_EXCEPTION_MESSAGE)).when(payPalPaymentStrategy).processPayment(anyDouble());

        Exception thrown = assertThrows(Exception.class, () -> processor.makePayment(paymentMethod, PAYMENT_AMOUNT));

        assertInstanceOf(PaymentProcessingException.class, thrown);
        assertEquals(TEST_EXCEPTION_MESSAGE, thrown.getMessage());
    }

    @Test
    void whenNewAdvancedPaymentProcessFail_thenThrowException() throws PaymentProcessingException {
        PaymentMethod paymentMethod = new NewAdvancedPayment(newAdvancedPaymentStrategy);
        when(newAdvancedPaymentStrategy.validatePaymentDetails()).thenReturn(true);
        doThrow(new PaymentProcessingException(TEST_EXCEPTION_MESSAGE)).when(newAdvancedPaymentStrategy).processPayment(anyDouble());

        Exception thrown = assertThrows(Exception.class, () -> processor.makePayment(paymentMethod, PAYMENT_AMOUNT));

        assertInstanceOf(PaymentProcessingException.class, thrown);
        assertEquals(TEST_EXCEPTION_MESSAGE, thrown.getMessage());
    }

}