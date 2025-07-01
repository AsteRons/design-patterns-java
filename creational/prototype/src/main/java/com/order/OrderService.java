package com.order;


import com.order.prototype.Order;

public class OrderService {
    public static void main( String[] args ) {

        Order baseOrder = new Order("Jan Kowalski");
        baseOrder.addItem("Laptop", 4000.0);
        baseOrder.addItem("Myszka", 100.0);

        Order orderForAnna = baseOrder.clone();
        orderForAnna.setCustomerName("Anna Nowak");
        orderForAnna.addItem("Torba", 200.0);

        System.out.println("Base Order:  " + baseOrder);
        System.out.println("Anna's Order: " + orderForAnna);

    }
}
