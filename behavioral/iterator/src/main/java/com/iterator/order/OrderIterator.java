package com.iterator.order;

public class OrderIterator implements Iterator<Order> {
    private final Order[] orders;
    private int position = 0;

    public OrderIterator(Order[] orders) {
        this.orders = orders;
    }

    @Override
    public boolean hasNext() {
        return position < orders.length && orders[position] != null;
    }

    @Override
    public Order next() {
        return orders[position++];
    }
}
