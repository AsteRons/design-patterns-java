package com.payment.decorator;

import com.payment.PaymentProcessor;

public class PaymentProcessorDecorator implements PaymentProcessor {

    protected PaymentProcessor wrappee;

    public PaymentProcessorDecorator(PaymentProcessor wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void pay(double amount) {

        wrappee.pay(amount);
    }
}
