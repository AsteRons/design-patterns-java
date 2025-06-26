package com.payment.port;

import com.payment.domain.PaymentRequest;
import com.payment.domain.PaymentResponse;

public interface PaymentProcessor {
    PaymentResponse processPayment(PaymentRequest request);
}
