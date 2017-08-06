package com.ordersserver.controllers.order;

import com.ordersserver.domainobjects.client.Client;
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

import java.util.LinkedList;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @Before
    public void setData(){
        when(orderService.retrieve(anyLong())).thenReturn(new Order());
        when(orderService.getAllOrders()).thenReturn(new LinkedList<>());
        when(orderService.getExecutedOrders()).thenReturn(new LinkedList<>());
        when(orderService.getUnexecutedOrders()).thenReturn(new LinkedList<>());
        doNothing().when(orderService).create(new Order());
        doNothing().when(orderService).update(new Order());
        doNothing().when(orderService).delete(anyLong());
    }

    @Test
    public void testGeetingOrderById() throws Exception {
        this.mockMvc.perform(get("/order/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testCreatingOrder() throws Exception {
        this.mockMvc.perform(post("/order/")
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testUpdatingOrder() throws Exception {
        this.mockMvc.perform(put("/order/")
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDeletingOrder() throws Exception {
        this.mockMvc.perform(delete("/order/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGeetingAllOrders() throws Exception {
        this.mockMvc.perform(get("/order/all"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGeetingUnexecutedOrders() throws Exception {
        this.mockMvc.perform(get("/order/unexecuted"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGeetingExecutedOrders() throws Exception {
        this.mockMvc.perform(get("/order/executed"))
                .andDo(print()).andExpect(status().isOk());
    }
}
