package com.ordersserver.services.order.impl;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.order.OrderRepository;
import com.ordersserver.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by perestoronin on 25.07.2017.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void create(Order order) {
        orderRepository.create(order);

    }

    @Override
    public Order retrieve(Long id) {
        return orderRepository.retrieve(id);
    }

    @Override
    public void update(Order order) {
        orderRepository.update(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);

    }

    @Override
    public Collection<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Collection<Order> getExecutedOrders() {
        return orderRepository.getExecutedOrders();
    }

    @Override
    public Collection<Order> getUnexecutedOrders() {
        return orderRepository.getUnexecutedOrders();
    }
}
