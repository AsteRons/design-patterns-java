package com.order.mediator;

import com.order.exception.OutOfStockException;
import com.order.exception.PaymentFailedException;
import com.order.model.Order;
import com.order.service.InventoryService;
import com.order.service.NotificationService;
import com.order.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderMediatorImpl implements OrderMediator {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderMediatorImpl(InventoryService inventoryService,
                             PaymentService paymentService,
                             NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    @Override
    public void processOrder(Order order) {
        log.info("Processing order: {}", order);

        try {
            inventoryService.reserveProducts(order.getProducts());
            paymentService.charge(order);
            notificationService.notifyCustomer(order);
            log.info("Order processed successfully: {}", order.getOrderId());

        } catch (OutOfStockException | PaymentFailedException e) {
            log.error("Order failed: {}", e.getMessage());
            notificationService.notifyFailure(order, e.getMessage());
        }
    }
}