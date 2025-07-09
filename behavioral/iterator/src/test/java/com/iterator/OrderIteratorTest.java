package com.iterator;

import com.iterator.order.Iterator;
import com.iterator.order.Order;
import com.iterator.order.OrderCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderIteratorTest {

    private OrderCollection orderCollection;

    @BeforeEach
    void setUp() {
        orderCollection = new OrderCollection(3);
        orderCollection.addOrder(new Order("ORD-001", 100.0));
        orderCollection.addOrder(new Order("ORD-002", 200.0));
        orderCollection.addOrder(new Order("ORD-003", 300.0));
    }

    @Test
    void testIteratorReturnsAllOrdersInOrder() {
        Iterator<Order> iterator = orderCollection.iterator();

        assertTrue(iterator.hasNext());
        Order first = iterator.next();
        assertEquals("ORD-001", first.orderId());

        assertTrue(iterator.hasNext());
        Order second = iterator.next();
        assertEquals("ORD-002", second.orderId());

        assertTrue(iterator.hasNext());
        Order third = iterator.next();
        assertEquals("ORD-003", third.orderId());

        assertFalse(iterator.hasNext());
    }
    @Test
    void testEmptyCollectionHasNoNext() {
        OrderCollection emptyCollection = new OrderCollection(2);
        Iterator<Order> iterator = emptyCollection.iterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorStopsAfterLastElement() {
        Iterator<Order> iterator = orderCollection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        assertFalse(iterator.hasNext());
    }
}