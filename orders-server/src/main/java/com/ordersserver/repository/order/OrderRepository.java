package com.ordersserver.repository.order;

import com.ordersserver.domainobjects.order.Order;

import java.util.Collection;

/**
 * @author Perestoronin Daniil
 */
public interface OrderRepository {

    Collection<Order> getAllOrders();
    Collection<Order> getExecutedOrders();
    Collection<Order> getUnexecutedOrders();
}
