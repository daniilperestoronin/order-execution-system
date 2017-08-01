package com.ordersserver.repository.order.impl;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.AbstractGenericDao;
import com.ordersserver.repository.order.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * Created by perestoronin on 25.07.2017.
 */
@Transactional
@Repository
public class OrderRepositoryImpl extends AbstractGenericDao<Order,Long> implements OrderRepository {
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
