package com.payment.client;

public record StripeChargeRequest(String customerReference, int amountInCents) {
}
