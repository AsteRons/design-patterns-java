package com.payment;

import com.payment.decorator.DiscountPaymentDecorator;
import com.payment.decorator.FraudCheckPaymentDecorator;
import com.payment.decorator.LoggingPaymentDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PaymentAppTest {

    private StringBuilder log;
    private PaymentProcessor processor;

    @BeforeEach
    void setUp() {
        log = new StringBuilder();

        processor = new PaymentProcessor() {
            @Override
            public void pay(double amount) {
              log.append(String.format("Paid: %.2f%n", amount));
            }
        };
    }

    @Test
    void testBasicPayment() {
        processor.pay(100);
        assertTrue(log.toString().contains("Paid: 100,00"));
    }
    @Test
    void testLoggingDecorator() {
        processor = new LoggingPaymentDecorator(processor) {
            @Override
            public void pay(double amount) {
                log.append("[LOG] Start\n");
                super.pay(amount);
                log.append("[LOG] End\n");
            }
        };

        processor.pay(50);

        String output = log.toString();
        assertTrue(output.contains("[LOG] Start"));
        assertTrue(output.contains("Paid: 50,00"));
        assertTrue(output.contains("[LOG] End"));
    }

    @Test
    void testDiscountDecorator() {
        processor = new DiscountPaymentDecorator(processor, 0.2);

        processor.pay(200);

        assertTrue(log.toString().contains("Paid: 160,00"));
    }

    @Test
    void testFraudCheckDecorator_AllowsSmallAmount() {
        processor = new FraudCheckPaymentDecorator(processor);

        processor.pay(999);
        assertTrue(log.toString().contains("Paid: 999,00"));
    }

    @Test
    void testFraudCheckDecorator_BlocksLargeAmount() {

        PaymentProcessor fraudCheckProcessor = new FraudCheckPaymentDecorator(processor) {
            @Override
            public void pay(double amount) {
                if (amount > 1000) {
                    log.append("Blocked due to fraud\n");
                    return;
                }
                super.pay(amount);
            }
        };

        fraudCheckProcessor.pay(1500);
        assertTrue(log.toString().contains("Blocked due to fraud"));
        assertFalse(log.toString().contains("Paid"));
    }

    @Test
    void testCombinedDecorators() {

        processor = new PaymentProcessor() {
            @Override
            public void pay(double amount) {
                log.append(String.format(Locale.US, "Paid: %.2f%n", amount));
            }
        };

        class TestLoggingDecorator extends LoggingPaymentDecorator {
            private final StringBuilder log;

            public TestLoggingDecorator(PaymentProcessor wrappee, StringBuilder log) {
                super(wrappee);
                this.log = log;
            }

            @Override
            public void pay(double amount) {
                log.append("[LOG] Start\n");
                super.pay(amount);
                log.append("[LOG] End\n");
            }
        }

        PaymentProcessor combined = new DiscountPaymentDecorator(
                new TestLoggingDecorator(
                        new FraudCheckPaymentDecorator(processor),
                        log), 0.1);


        combined.pay(500);

        String output = log.toString();
        assertTrue(output.contains("[LOG] Start"));
        assertTrue(output.contains("Paid: 450.00")); // 10% discount applied
        assertTrue(output.contains("[LOG] End"));
    }

}