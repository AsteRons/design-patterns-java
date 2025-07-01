package com.payment.decorator;

import com.payment.PaymentProcessor;

public class LoggingPaymentDecorator extends PaymentProcessorDecorator {

    public LoggingPaymentDecorator(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Payment started.");
        super.pay(amount);
        System.out.println("[LOG] Payment completed.");
    }
}
