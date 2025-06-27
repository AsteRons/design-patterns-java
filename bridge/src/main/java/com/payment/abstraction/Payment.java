package com.payment.abstraction;

import com.payment.implementation.PaymentProcessor;

import java.util.List;


public abstract class Payment {
    protected List<PaymentProcessor> processors;

    public Payment(List<PaymentProcessor> processors) {
        this.processors = processors;
    }

    protected double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }
        if (fromCurrency.equals("USD") && toCurrency.equals("PLN")) {
            return amount * 4;
        }
        if (fromCurrency.equals("PLN") && toCurrency.equals("USD")) {
            return amount / 4;
        }
        return amount;
    }

    public void makePayment(double amount, String currency) {
        for (PaymentProcessor processor : processors) {

            double convertedAmount = convertCurrency(amount, currency, "USD");

            processor.payAsync(convertedAmount, "USD")
                    .thenAccept(success -> {
                        if (success) {
                            System.out.println("The payment was successfully completed via " + processor.getClass().getSimpleName());
                        } else {
                            System.out.println("The payment failed via " + processor.getClass().getSimpleName());
                            processor.rollback();
                        }
                    });
        }
    }
}
