package com.ordersystem;

import static org.junit.jupiter.api.Assertions.*;

import com.ordersystem.command.CancelOrderCommand;
import com.ordersystem.command.Command;
import com.ordersystem.command.PlaceOrderCommand;
import com.ordersystem.invoker.OrderInvoker;
import com.ordersystem.reciver.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OrderCommandTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    private Order order;
    private OrderInvoker invoker;

    @BeforeEach
    void setUp() {

        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        order = new Order("1234");
        invoker = new OrderInvoker();
    }
    @Test
    void testPlaceOrderCommandExecuteAndUndo() {
        Command placeOrder = new PlaceOrderCommand(order);

        invoker.executeCommand(placeOrder);
        assertTrue(outContent.toString().contains("Order 1234 has been placed."));

        outContent.reset();

        invoker.undo();
        assertTrue(outContent.toString().contains("Order 1234 has been canceled."));
    }

    @Test
    void testCancelOrderCommandExecuteAndUndo() {
        Command cancelOrder = new CancelOrderCommand(order);

        invoker.executeCommand(cancelOrder);
        assertTrue(outContent.toString().contains("Order 1234 has been canceled."));

        outContent.reset();

        invoker.undo();
        assertTrue(outContent.toString().contains("Order 1234 has been placed."));
    }

    @Test
    void testUndoWithNoCommands() {
        invoker.undo();
        assertTrue(outContent.toString().contains("No commands to undo."));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}