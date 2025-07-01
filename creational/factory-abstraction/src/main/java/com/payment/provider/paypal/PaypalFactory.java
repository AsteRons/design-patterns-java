package com.payment.provider.paypal;

import com.payment.domain.CurrencyConverterService;
import com.payment.domain.FraudCheckService;
import com.payment.domain.PaymentService;
import com.payment.domain.RefundService;
import com.payment.factory.PaymentProviderFactory;

public class PaypalFactory implements PaymentProviderFactory {
    public PaymentService createPaymentService() {
        return new PaypalPaymentService();
    }

    public RefundService createRefundService() {
        return new PaypalRefundService();
    }

    public FraudCheckService createFraudCheckService() {
        return new PaypalFraudCheckService();
    }

    public CurrencyConverterService createCurrencyConverterService() {
        return new PaypalCurrencyConverterService();
    }
}
