package com.payment.provider.paypal;

import com.payment.domain.CurrencyConverterService;

import java.util.Map;

class PaypalCurrencyConverterService implements CurrencyConverterService {
    private static final Map<String, Double> exchangeRates = Map.of(
            "USD", 1.1,
            "EUR", 1.2,
            "JPY", 0.008,
            "GBP", 1.4);

    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        System.out.println("PayPal: Converting " + amount + " from " + fromCurrency + " to " + toCurrency);

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency code.");
        }
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }
}
