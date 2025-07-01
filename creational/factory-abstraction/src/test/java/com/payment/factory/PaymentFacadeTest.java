package com.payment.factory;

import com.payment.domain.CurrencyConverterService;
import com.payment.domain.FraudCheckService;
import com.payment.domain.PaymentService;
import com.payment.domain.RefundService;
import com.payment.registry.PaymentProviderType;
import com.payment.registry.PaymentFactoryRegistry;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentFacadeTest {

    @Mock
    private PaymentService paymentService;
    @Mock
    private RefundService refundService;
    @Mock
    private FraudCheckService fraudCheckService;
    @Mock
    private CurrencyConverterService currencyConverterService;
    @Mock
    private PaymentProviderFactory factory;
    @InjectMocks
    private PaymentFacade facade;

    @Test
    void paymentStripeMethodTest() {

        String userId = "user123";
        double amount = 1000.0;
        String fromCurrency = "EUR";
        String toCurrency = "USD";

        String provider = "stripe";

        PaymentProviderType providerType;

        providerType = PaymentProviderType.valueOf(provider.toUpperCase());

        PaymentProviderFactory factory = PaymentFactoryRegistry.getFactory(providerType);

        PaymentFacade facade = new PaymentFacade(factory);

        facade.pay(userId, amount, fromCurrency, toCurrency);

    }
}