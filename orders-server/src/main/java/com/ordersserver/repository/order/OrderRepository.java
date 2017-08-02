package com.ordersserver.repository.order;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author Perestoronin Daniil
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
