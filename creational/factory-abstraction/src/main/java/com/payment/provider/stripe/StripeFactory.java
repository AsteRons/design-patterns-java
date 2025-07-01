package com.payment.provider.stripe;

import com.payment.domain.CurrencyConverterService;
import com.payment.domain.FraudCheckService;
import com.payment.domain.PaymentService;
import com.payment.domain.RefundService;
import com.payment.factory.PaymentProviderFactory;

public class StripeFactory implements PaymentProviderFactory {
    @Override
    public PaymentService createPaymentService() {
        return new StripePaymentService();
    }

    @Override
    public RefundService createRefundService() {
        return new StripeRefundService();
    }

    @Override
    public FraudCheckService createFraudCheckService() {
        return new StripeFraudCheckService();
    }

    @Override
    public CurrencyConverterService createCurrencyConverterService() {
        return new StripeCurrencyConverterService();
    }
}
