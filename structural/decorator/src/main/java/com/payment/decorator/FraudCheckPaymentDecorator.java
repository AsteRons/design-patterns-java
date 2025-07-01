package com.payment.decorator;

import com.payment.PaymentProcessor;

public class FraudCheckPaymentDecorator extends PaymentProcessorDecorator {

    public FraudCheckPaymentDecorator(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public void pay(double amount) {
        if (isFraudulent(amount)) {
            System.out.println("Payment blocked due to fraud suspicion.");
            return;
        }
        super.pay(amount);
    }

    private boolean isFraudulent(double amount) {
        return amount > 1000;
    }
}
