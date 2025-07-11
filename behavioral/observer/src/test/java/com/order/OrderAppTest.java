package com.order;


import com.order.dispatcher.OrderStatusEventDispatcher;
import com.order.listener.AuditLogListener;
import com.order.listener.EmailNotificationListener;
import com.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicBoolean;


import static org.assertj.core.api.Assertions.assertThat;

class OrderAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Order order;
    private OrderStatusEventDispatcher dispatcher;

    @BeforeEach
    void setUp() {

        System.setOut(new PrintStream(outContent));

        dispatcher = new OrderStatusEventDispatcher();

        dispatcher = new OrderStatusEventDispatcher();

        dispatcher.register(new AuditLogListener());
        dispatcher.register(new EmailNotificationListener());

        order = Order.builder()
                .id("ORD-TEST-001")
                .customerEmail("test@example.com")
                .status("CREATED")
                .build();

        order.setDispatcher(dispatcher);
    }

    @Test
    void shouldNotifyAllListenersWhenStatusChanges() {
        // When
        order.setStatus("PAID");

        // Then
        String output = outContent.toString();

        assertThat(output).contains("Audit: Order ORD-TEST-001 status changed from CREATED to PAID");

    }

    @Test
    void shouldNotNotifyWhenStatusIsUnchanged() {

        order.setStatus("CREATED");

        String output = outContent.toString();
        assertThat(output).doesNotContain("Audit");

    }
}