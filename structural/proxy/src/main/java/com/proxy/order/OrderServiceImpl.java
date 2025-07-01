package com.proxy.order;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderById(Long id) {
        simulateDatabaseCall();
        System.out.println("Fetching order from database: " + id);
        return new Order(id, "Order-" + id, 100.0);
    }

    private void simulateDatabaseCall() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
