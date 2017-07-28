package com.ordersserver.repository.order;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.GenericDao;

import java.util.Collection;

/**
 * @author Perestoronin Daniil
 */
public interface OrderRepository extends GenericDao<Order,Long> {

    Collection<Order> getAllOrders();
    Collection<Order> getExecutedOrders();
    Collection<Order> getUnexecutedOrders();
}
