package com.proxy;


import com.proxy.order.OrderService;
import com.proxy.order.OrderServiceImpl;
import com.proxy.order.OrderServiceProxy;

public class ProxyApp {
    public static void main( String[] args ) {

        OrderService realService = new OrderServiceImpl();
        OrderService proxy = new OrderServiceProxy(realService);


        System.out.println(proxy.getOrderById(1L));


        System.out.println(proxy.getOrderById(1L));

    }
}
