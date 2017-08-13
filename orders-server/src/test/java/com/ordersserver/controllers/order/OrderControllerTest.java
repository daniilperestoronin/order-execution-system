package com.ordersserver.controllers.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.client.ClientType;
import com.ordersserver.domainobjects.client.PersonalInformation;
import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.services.order.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by perestoronin on 02.08.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private OrderService orderService;
    private Client customer, executor;
    private Order order, executeOrder;
    private List<Order> allOrders, executedOrders, unexecutedOrders;

    @Before
    public void setData(){
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
        when(orderService.retrieve(order.getId())).thenReturn(order);
        when(orderService.getAllOrders()).thenReturn(allOrders);
        when(orderService.getExecutedOrders()).thenReturn(executedOrders);
        when(orderService.getUnexecutedOrders()).thenReturn(unexecutedOrders);
        doNothing().when(orderService).create(order);
        doNothing().when(orderService).update(order);
        doNothing().when(orderService).delete(order.getId());
    }

    @Test
    public void testGettingOrderById() throws Exception {
        this.mockMvc.perform(get("/order/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .string(new ObjectMapper().writeValueAsString(order)));
    }

    @Test
    public void testCreatingOrder() throws Exception {
        this.mockMvc.perform(post("/order/")
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testUpdatingOrder() throws Exception {
        this.mockMvc.perform(put("/order/")
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDeletingOrder() throws Exception {
        this.mockMvc.perform(delete("/order/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGettingAllOrders() throws Exception {
        this.mockMvc.perform(get("/order/all"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .string(new ObjectMapper().writeValueAsString(allOrders)));
    }

    @Test
    public void testGettingUnexecutedOrders() throws Exception {
        this.mockMvc.perform(get("/order/unexecuted"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .string(new ObjectMapper().writeValueAsString(unexecutedOrders)));
    }

    @Test
    public void testGettingExecutedOrders() throws Exception {
        this.mockMvc.perform(get("/order/executed"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content()
                        .string(new ObjectMapper().writeValueAsString(executedOrders)));
    }
}
