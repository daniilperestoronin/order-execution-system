package com.ordersserver.services.order;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.client.ClientType;
import com.ordersserver.domainobjects.client.PersonalInformation;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    private Client customer, executor;
    private Order order, executeOrder;
    private List<Order> allOrders, executedOrders, unexecutedOrders;

    @Before
    public void setData() {
        allOrders = new ArrayList<>();
        executedOrders = new ArrayList<>();
        unexecutedOrders = new ArrayList<>();
        customer = new Client()
                .setId(1L)
                .setClientType(ClientType.CUSTOMER)
                .setPersonalInformation(new PersonalInformation()
                        .setId(1L)
                        .setFirstName("testFirstName")
                        .setMiddleName("testMiddleName")
                        .setLastName("testLastName")
                        .setIdentifier("testIdentifier")
                        .setPassword("testPassword"));
        executor = new Client()
                .setId(2L)
                .setClientType(ClientType.EXECUTOR)
                .setPersonalInformation(new PersonalInformation()
                        .setId(2L)
                        .setFirstName("testFirstName")
                        .setMiddleName("testMiddleName")
                        .setLastName("testLastName")
                        .setIdentifier("testIdentifier")
                        .setPassword("testPassword"));
        order = new Order()
                .setId(1L)
                .setCustomer(customer)
                .setAddress("")
                .setDescription("");
        executeOrder = new Order()
                .setId(2L)
                .setCustomer(customer)
                .setExecutor(executor)
                .setAddress("")
                .setDescription("");
        allOrders.add(order);
        allOrders.add(executeOrder);
        executedOrders.add(executeOrder);
        unexecutedOrders.add(order);
        when(orderRepository.findOne(order.getId())).thenReturn(order);
        when(orderRepository.save(order)).thenReturn(order);
        when(orderRepository.findAll()).thenReturn(allOrders);
        when(orderRepository.findExecutedOrders()).thenReturn(executedOrders);
        when(orderRepository.findUnexecutedOrders()).thenReturn(unexecutedOrders);
        doNothing().when(orderRepository).delete(order.getId());
    }

    @Test
    public void testCreate() {
        orderService.create(order);
    }

    @Test
    public void testRetrieve() {
        assertEquals(orderService.retrieve(order.getId()), order);
    }

    @Test
    public void testUpdate() {
        orderService.update(order);
    }

    @Test
    public void testDelete() {
        orderService.delete(order.getId());
    }

    @Test
    public void testGetAllOrders() {
        assertEquals(orderService.getAllOrders(),allOrders);
    }

    @Test
    public void testGetExecutedOrders() {
        assertEquals(orderService.getExecutedOrders(),executedOrders);
    }

    @Test
    public void testGetUnexecutedOrders() {
        assertEquals(orderService.getUnexecutedOrders(),unexecutedOrders);
    }
}

