package com.payment.provider.stripe;

import com.payment.domain.CurrencyConverterService;

import java.util.HashMap;
import java.util.Map;

class StripeCurrencyConverterService implements CurrencyConverterService {

    private static final Map<String, Double> exchangeRates = Map.of(
            "USD", 1.0,
            "EUR", 2.0,
            "JPY", 0.007,
            "GBP", 1.3);

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        System.out.println("Stripe: Converting " + amount + " from " + fromCurrency + " to " + toCurrency);

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency code.");
        }
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }
}
