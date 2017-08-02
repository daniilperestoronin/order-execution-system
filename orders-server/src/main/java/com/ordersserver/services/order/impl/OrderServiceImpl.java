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
        orderRepository.save(order);

    }

    @Override
    public Order retrieve(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);

    }

    @Override
    public Collection<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Collection<Order> getExecutedOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Collection<Order> getUnexecutedOrders() {
        return orderRepository.findAll();
    }
}
