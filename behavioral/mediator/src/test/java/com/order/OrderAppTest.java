package com.order;

import com.order.exception.OutOfStockException;
import com.order.exception.PaymentFailedException;
import com.order.mediator.OrderMediator;
import com.order.mediator.OrderMediatorImpl;
import com.order.service.InventoryService;
import com.order.model.Order;
import com.order.model.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.order.service.NotificationService;
import com.order.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.List;

class OrderAppTest {
        private InventoryService inventoryService;
        private PaymentService paymentService;
        private NotificationService notificationService;

        private OrderMediator mediator;

        private Order sampleOrder;

        @BeforeEach
        void setUp() {
            inventoryService = mock(InventoryService.class);
            paymentService = mock(PaymentService.class);
            notificationService = mock(NotificationService.class);

            mediator = new OrderMediatorImpl(inventoryService, paymentService, notificationService);

            sampleOrder = new Order(
                    "john.doe@example.com",
                    List.of(
                            new Product("SKU-100", 2, 50.0),
                            new Product("SKU-200", 1, 75.0)
                    )
            );
        }

        @Test
        void shouldProcessOrderSuccessfully() throws Exception {
            // when
            mediator.processOrder(sampleOrder);

            // then
            InOrder inOrder = inOrder(inventoryService, paymentService, notificationService);
            inOrder.verify(inventoryService).reserveProducts(sampleOrder.getProducts());
            inOrder.verify(paymentService).charge(sampleOrder);
            inOrder.verify(notificationService).notifyCustomer(sampleOrder);

            verify(notificationService, never()).notifyFailure(any(), any());
        }

        @Test
        void shouldNotifyFailureWhenInventoryFails() throws Exception {
            // given
            doThrow(new OutOfStockException("Out of stock")).when(inventoryService)
                    .reserveProducts(sampleOrder.getProducts());

            // when
            mediator.processOrder(sampleOrder);

            // then
            verify(inventoryService).reserveProducts(sampleOrder.getProducts());
            verifyNoInteractions(paymentService);
            verify(notificationService).notifyFailure(eq(sampleOrder), contains("Out of stock"));
            verify(notificationService, never()).notifyCustomer(any());
        }

        @Test
        void shouldNotifyFailureWhenPaymentFails() throws Exception {

            // given
            doNothing().when(inventoryService).reserveProducts(sampleOrder.getProducts());
            doThrow(new PaymentFailedException("Payment error")).when(paymentService)
                    .charge(sampleOrder);

            // when
            mediator.processOrder(sampleOrder);

            // then
            verify(inventoryService).reserveProducts(sampleOrder.getProducts());
            verify(paymentService).charge(sampleOrder);
            verify(notificationService).notifyFailure(eq(sampleOrder), contains("Payment error"));
            verify(notificationService, never()).notifyCustomer(any());
        }
    }