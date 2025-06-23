package com.payment.factory;

import com.payment.domain.CurrencyConverterService;
import com.payment.domain.FraudCheckService;
import com.payment.domain.PaymentService;
import com.payment.domain.RefundService;

public interface PaymentProviderFactory {
    PaymentService createPaymentService();
    RefundService createRefundService();
    FraudCheckService createFraudCheckService();
    CurrencyConverterService createCurrencyConverterService();
}
