package com.ordersserver.repository.order;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.client.ClientType;
import com.ordersserver.domainobjects.client.PersonalInformation;
import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.repository.client.ClientRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by perestoronin on 07.08.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    private static Client customer, executor;
    private static Order order, executeOrder;
    private static List<Order> allOrders, executedOrders, unexecutedOrders;

    @BeforeClass
    public static void setData() {
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
    }

    @Test
    public void testSaveClient() {
        clientRepository.save(customer);
        clientRepository.save(executor);
        assertEquals(orderRepository.save(order), order);
        assertEquals(orderRepository.save(executeOrder), executeOrder);
    }

    @Test
    public void testFindClient() {
        clientRepository.save(customer);
        clientRepository.save(executor);
        orderRepository.save(order);
        assertEquals(orderRepository.getOne(order.getId()),order);
    }

    @Test
    public void testDeleteClient() {
        clientRepository.save(customer);
        clientRepository.save(executor);
        Order testOrder = orderRepository.save(order);
        clientRepository.delete(testOrder.getId());
    }

    @Test
    public void testFindAllOrders(){
        clientRepository.save(customer);
        clientRepository.save(executor);
        orderRepository.save(order);
        orderRepository.save(executeOrder);
        assertEquals(allOrders,orderRepository.findAll());
    }

    @Test
    public void testFindExecutedOrders(){
        clientRepository.save(customer);
        clientRepository.save(executor);
        orderRepository.save(order);
        orderRepository.save(executeOrder);
        assertEquals(executedOrders,orderRepository.findExecutedOrders());
    }

    @Test
    public void testFindUnexecutedOrders(){
        clientRepository.save(customer);
        clientRepository.save(executor);
        orderRepository.save(order);
        orderRepository.save(executeOrder);
        assertEquals(unexecutedOrders,orderRepository.findUnexecutedOrders());
    }

}
