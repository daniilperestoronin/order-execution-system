package com.ordersserver.repository.order;

import com.ordersserver.domainobjects.order.Order;

import java.util.Collection;

/**
 * @author Perestoronin Daniil
 */
public interface OrderRepository {

    Collection<Order> getAllOreders();
    Collection<Order> getExecutedOrders();
    Collection<Order> getUnexecutedOrders();
}
