package com.iterator.order;

public class OrderCollection {
    private final Order[] orders;
    private int index = 0;

    public OrderCollection(int size) {
        this.orders = new Order[size];
    }

    public void addOrder(Order order) {
        if (index < orders.length) {
            orders[index++] = order;
        }
    }

    public Iterator<Order> iterator() {
        return new OrderIterator(orders);
    }
}