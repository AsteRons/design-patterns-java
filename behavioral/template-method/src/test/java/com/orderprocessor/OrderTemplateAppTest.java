package com.orderprocessor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class OrderTemplateAppTest {


    @Test
    void testOnlineOrderProcessorFlow() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OrderProcessor processor = new OnlineOrderProcessor();
        processor.processOrder();

        String output = out.toString();

        assertTrue(output.contains("Validating online order"));
        assertTrue(output.contains("Charging customer via online payment gateway"));
        assertTrue(output.contains("Shipping order to customer's delivery address"));
        assertTrue(output.contains("Sending order confirmation email"));
    }

    @Test
    void testInStorePickupOrderProcessorFlow() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        OrderProcessor processor = new InStorePickupOrderProcessor();
        processor.processOrder();

        String output = out.toString();

        assertTrue(output.contains("Validating in-store pickup availability"));
        assertTrue(output.contains("Reserving payment for in-store pickup"));
        assertTrue(output.contains("Notifying store staff for pickup preparation"));
        assertTrue(output.contains("Sending pickup confirmation SMS"));
    }

    @Test
    void testTemplateMethodOrderIsFinal() throws NoSuchMethodException {
        var method = OrderProcessor.class.getDeclaredMethod("processOrder");
        assertTrue(java.lang.reflect.Modifier.isFinal(method.getModifiers()),
                "processOrder() should be final to enforce template structure");
    }
}