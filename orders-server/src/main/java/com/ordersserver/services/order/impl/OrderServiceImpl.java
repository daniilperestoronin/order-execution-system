package com.ordersserver.services.order.impl;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.services.order.OrderService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by perestoronin on 25.07.2017.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public void create(Order client) {

    }

    @Override
    public Order retrieve(Long id) {
        return null;
    }

    @Override
    public void update(Order t) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Collection<Order> getAllOrders() {
        return null;
    }

    @Override
    public Collection<Order> getExecutedOrders() {
        return null;
    }

    @Override
    public Collection<Order> getUnexecutedOrders() {
        return null;
    }
}
