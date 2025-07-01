package com.payment.registry;

import com.payment.factory.PaymentProviderFactory;
import com.payment.provider.paypal.PaypalFactory;
import com.payment.provider.stripe.StripeFactory;

import java.util.Map;

public class PaymentFactoryRegistry {

    private static final Map<PaymentProviderType, PaymentProviderFactory> FACTORY_MAP = Map.of(
            PaymentProviderType.STRIPE, new StripeFactory(),
            PaymentProviderType.PAYPAL, new PaypalFactory()
    );

    public static PaymentProviderFactory getFactory(PaymentProviderType type) {
        return FACTORY_MAP.getOrDefault(type, new PaypalFactory());
    }
}
