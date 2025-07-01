package com.payment;


import com.payment.abstraction.OneTimePayment;
import com.payment.abstraction.Payment;
import com.payment.implementation.CreditCardProcessor;
import com.payment.implementation.PayPalProcessor;
import com.payment.implementation.PaymentProcessor;

import java.util.List;

public class BridgePatternDemo {
    public static void main( String[] args ) {

        PaymentProcessor paypal = new PayPalProcessor();
        PaymentProcessor creditCard = new CreditCardProcessor();

        Payment payment = new OneTimePayment(List.of(paypal, creditCard));
        payment.makePayment(100, "PLN");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
