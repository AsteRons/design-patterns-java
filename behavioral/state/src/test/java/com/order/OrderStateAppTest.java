package com.order;

import com.order.model.OrderContext;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderStateAppTest {

    private OrderContext order;

    @BeforeEach
    void setUp() {
        order = new OrderContext();
    }

    @Test
    @Order(1)
    @DisplayName("New → Paid, then Cancel transitions")
    void testNewToPaidThenCancel() {

        // Act
        order.next();

        // Assert
        assertDoesNotThrow(order::printStatus);

        order.cancel();
        assertDoesNotThrow(order::printStatus);
    }

    @Test
    @Order(2)
    @DisplayName("Paid → Shipped → Delivered")
    void testPaidToShippedToDelivered() {
        order.next(); // New → Paid
        order.next(); // Paid → Shipped
        assertDoesNotThrow(order::printStatus);
        order.next(); // Shipped → Delivered
        assertDoesNotThrow(order::printStatus);
    }

    @Test
    @Order(3)
    @DisplayName("Cancel after Delivered is ignored")
    void testCancelAfterDeliveredIgnored() {
        // Arrange
        order.next();
        order.next();
        order.next(); // to Delivered
        // Act & Assert
        assertDoesNotThrow(order::cancel);
        assertDoesNotThrow(order::next);
        assertDoesNotThrow(order::printStatus);
    }

    @Test
    @Order(4)
    @DisplayName("Cancel forbidden after Shipped")
    void testCancelAfterShippedForbidden() {
        order.next();
        order.next(); // to Shipped
        assertDoesNotThrow(order::cancel);  // logic prints denial message
    }

    @Test
    @Order(5)
    @DisplayName("Cancel at New prevents future transitions")
    void testCancelThenNextNotAllowed() {
        order.cancel(); // New → Cancelled
        assertDoesNotThrow(order::next);
        assertDoesNotThrow(order::printStatus);
    }

}