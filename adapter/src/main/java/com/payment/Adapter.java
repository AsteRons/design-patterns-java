package com.payment;

import com.payment.adapter.StripePaymentAdapter;
import com.payment.client.StripeClient;
import com.payment.port.PaymentProcessor;
import com.payment.service.PaymentService;

public class Adapter {
    public static void main( String[] args ) {

        StripeClient stripeClient = new StripeClient();
        PaymentProcessor adapter = new StripePaymentAdapter(stripeClient);

        PaymentService paymentService = new PaymentService(adapter);

        paymentService.makePayment("cust123", 59.99);
    }
}
