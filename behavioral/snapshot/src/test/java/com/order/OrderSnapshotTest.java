package com.order;

import static org.junit.jupiter.api.Assertions.*;

import com.order.model.Order;
import com.order.model.Product;

import com.order.snapshot.OrderCaretaker;
import com.order.snapshot.SnapshotableOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class OrderSnapshotTest {

    private SnapshotableOrder snapshotableOrder;
    private OrderCaretaker caretaker;

    private Order initialOrder;

    @BeforeEach
    void setup() {
        initialOrder = Order.builder()
                .id("order-123")
                .customerEmail("john@example.com")
                .products(List.of(
                        Product.builder().sku("sku-1").price(10.0).quantity(2).build(),
                        Product.builder().sku("sku-2").price(20.0).quantity(1).build()))
                .build();

        snapshotableOrder = new SnapshotableOrder(initialOrder);
        caretaker = new OrderCaretaker();
    }

    @Test
    void backupShouldCreateSnapshotAndStoreHistory() {
        caretaker.backup(snapshotableOrder);

        assertThat(caretaker.hasHistory()).isTrue();
    }

    @Test
    void undoShouldRestoreOrderToPreviousState() {
        caretaker.backup(snapshotableOrder);


        Order modifiedOrder = Order.builder()
                .id("order-123")
                .customerEmail("jane@example.com")
                .products(List.of(
                        Product.builder().sku("sku-3").price(30.0).quantity(5).build()))
                .build();
        snapshotableOrder.setOrder(modifiedOrder);


        caretaker.undo(snapshotableOrder);

        Order restoredOrder = snapshotableOrder.getOrder();


        assertThat(restoredOrder.getCustomerEmail()).isEqualTo(initialOrder.getCustomerEmail());
        assertThat(restoredOrder.getProducts()).hasSize(2);
        assertThat(restoredOrder.getProducts())
                .extracting("sku")
                .containsExactlyInAnyOrder("sku-1", "sku-2");
    }

    @Test
    void undoShouldDoNothingIfNoHistory() {

        Order beforeUndo = snapshotableOrder.getOrder();

        caretaker.undo(snapshotableOrder);

        assertThat(snapshotableOrder.getOrder()).isSameAs(beforeUndo);
    }
}