package com.payment.client;

public class StripeClient {
    public StripeChargeResponse charge(StripeChargeRequest request) {

        System.out.println("Calling Stripe API with amount: " + request.amountInCents());
        return new StripeChargeResponse("stripe_txn_789", true);
    }
}
