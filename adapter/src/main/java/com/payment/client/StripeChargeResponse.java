package com.payment.client;

public record StripeChargeResponse(String transactionId, boolean paid) {
}
