package com.ordersserver.repository.order;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * @author Perestoronin Daniil
 */
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o where o.executor IS NOT NULL")
    List<Order> findExecutedOrders();

    @Query("SELECT o FROM Order o where o.executor IS NULL")
    List<Order> findUnexecutedOrders();
}
