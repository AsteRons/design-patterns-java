package com.payment.adapter;

import com.payment.client.StripeChargeRequest;
import com.payment.client.StripeChargeResponse;
import com.payment.client.StripeClient;
import com.payment.domain.PaymentRequest;
import com.payment.domain.PaymentResponse;
import com.payment.port.PaymentProcessor;

public class StripePaymentAdapter implements PaymentProcessor {
    private final StripeClient stripeClient;

    public StripePaymentAdapter(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        StripeChargeRequest stripeRequest = new StripeChargeRequest(
                request.customerId(),
                (int)(request.amount() * 100)
        );

        StripeChargeResponse stripeResponse = stripeClient.charge(stripeRequest);

        return new PaymentResponse(
                stripeResponse.paid(),
                stripeResponse.transactionId()
        );
    }
}
