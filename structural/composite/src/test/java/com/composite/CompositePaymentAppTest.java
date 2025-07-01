package com.composite;

import com.composite.payment.Payment;
import com.composite.payment.composite.CompositePayment;
import com.composite.payment.methods.BankTransfer;
import com.composite.payment.methods.CreditCardPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CompositePaymentAppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSingleCreditCardPayment() {
        Payment card = new CreditCardPayment("1234567890123456");
        card.pay(150.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Paying 150,00 PLN"));
        assertTrue(output.contains("3456"));
    }

    @Test
    void testSingleBankTransferPayment() {
        Payment transfer = new BankTransfer("PL61109010140000071219812874");
        transfer.pay(300.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Paying 300,00 PLN"));
        assertTrue(output.contains("PL61109010140000071219812874"));
    }

    @Test
    void testCompositePaymentSplitsAmount() {
        CompositePayment composite = new CompositePayment();


        composite.add(new CreditCardPayment("1111222233334444"));
        composite.add(new BankTransfer("PL00112233445566778899000000"));

        composite.pay(200.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Paying 100,00 PLN"));
        assertTrue(output.contains("Paying 100,00 PLN"));
    }

    @Test
    void testEmptyCompositePayment() {
        CompositePayment composite = new CompositePayment();
        composite.pay(100.0);

        String output = outputStream.toString();
        assertTrue(output.contains("No payment methods available!"));
    }

}