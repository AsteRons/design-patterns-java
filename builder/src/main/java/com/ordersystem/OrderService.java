package com.ordersystem;

import com.ordersystem.model.Address;
import com.ordersystem.model.Item;
import com.ordersystem.model.Order;
import com.ordersystem.model.OrderBuilder;

public class OrderService {
    public static void main( String[] args ) {

        Address address = new Address.AddressBuilder()
                .street("123 Java St")
                .city("Springfield")
                .zipCode("12345")
                .build();

        Order order = new OrderBuilder<>()
                .orderId("ORD-001")
                .shippingAddress(address)
                .addItem(new Item("P-100", 2, 49.99))
                .addItem(new Item("P-200", 1, 29.99))
                .expedited(true)
                .build();

        System.out.println(order);
    }
}
