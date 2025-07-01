package com.proxy.order;

public class Order {
    private Long id;
    private String description;
    private Double total;

    public Order(Long id, String description, Double total) {
        this.id = id;
        this.description = description;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", description='" + description + "', total=" + total + '}';
    }
}
