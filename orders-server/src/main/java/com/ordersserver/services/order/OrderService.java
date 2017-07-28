package com.ordersserver.services.order;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.order.Order;

import java.util.Collection;

/**
 * Created by perestoronin on 25.07.2017.
 */
public interface OrderService {

    void create(Order order);
    Order retrieve(Long id);
    void update(Order t);
    void delete(Long id);
    Collection<Order> getAllOrders();
    Collection<Order> getExecutedOrders();
    Collection<Order> getUnexecutedOrders();
}
