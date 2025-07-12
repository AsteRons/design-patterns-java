package com.order;

import static org.junit.jupiter.api.Assertions.*;
import com.order.model.Order;

import com.order.strategy.CreditCardPayment;
import com.order.strategy.NoPayment;
import com.order.strategy.PayPalPayment;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class OrderStrategyAppTest {


    @Test
    @DisplayName("Credit card payment marks order as paid")

    void testCreditCardPayment() {
        Order order = new Order(new CreditCardPayment("4123"));

        assertFalse(order.isPaid());

        order.process(150.00);
        assertTrue(order.isPaid());
    }

    @Test
    @DisplayName("PayPal payment marks order as paid")
    void testPayPalPayment() {
        Order order = new Order(new PayPalPayment("user@example.com"));
        assertFalse(order.isPaid());

        order.process(75.50);
        assertTrue(order.isPaid());
    }

    @Test
    @DisplayName("NoPayment leaves order unpaid")
    void testNoPaymentStrategy() {
        Order order = new Order(new NoPayment());
        order.process(200.00);
        assertFalse(order.isPaid());
    }

    @Test
    @DisplayName("Switching payment strategy at runtime")
    void testSwitchStrategy() {
        Order order = new Order(new NoPayment());
        assertFalse(order.isPaid());

        order.process(50.00);
        assertFalse(order.isPaid());

        order.setPaymentStrategy(new CreditCardPayment("1234567890123456"));
        order.process(50.00);
        assertTrue(order.isPaid());
    }

}