package com.ordersserver.controllers.order;

import com.ordersserver.domainobjects.order.Order;
import com.ordersserver.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by perestoronin on 25.07.2017.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.retrieve(id);
    }

    @PostMapping("/")
    public void createOrder(@RequestBody Order order) {
        orderService.create(order);
    }

    @PutMapping("/")
    public void updateOrderById(@RequestBody Order order) {
        orderService.update(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping("/all")
    public Collection<Order> getOrderById() {
        return orderService.getAllOrders();
    }

    @GetMapping("/unexecuted")
    public Collection<Order> getUnexecutedOrders() {
        return orderService.getUnexecutedOrders();
    }

    @GetMapping("/executed")
    public Collection<Order> getExecutedOrders() {
        return orderService.getExecutedOrders();
    }
}
