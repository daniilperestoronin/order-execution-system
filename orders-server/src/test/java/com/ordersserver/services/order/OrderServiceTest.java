package com.ordersserver.services.order;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.order.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by perestoronin on 03.08.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @MockBean
    private OrderRepository orderRepository;
    private Order order;

    @Before
    public void setData() {
        when(orderRepository.findOne(anyLong())).thenReturn(new Order());
        when(orderRepository.save(order)).thenReturn(order);
        doNothing().when(orderRepository).delete(anyLong());
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());

        order = new Order();
    }

    @Test
    public void testCreate() {
        orderService.create(order);
    }

    @Test
    public void testRetrieve() {
        orderService.retrieve(1L);
    }

    @Test
    public void testUpdate() {
        orderService.update(order);
    }

    @Test
    public void testDelete() {
        orderService.delete(1L);
    }

    @Test
    public void testGetAllOrders() {
        orderService.getAllOrders();
    }

    @Test
    public void testGetExecutedOrders() {
        orderService.getExecutedOrders();
    }

    @Test
    public void testGetUnexecutedOrders() {
        orderService.getUnexecutedOrders();
    }
}

