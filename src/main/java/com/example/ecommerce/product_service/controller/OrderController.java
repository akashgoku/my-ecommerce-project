package com.example.ecommerce.product_service.controller;

import com.example.ecommerce.product_service.entity.Order;
import com.example.ecommerce.product_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long userId,
                                             @RequestParam Long productId,
                                             @RequestParam Integer quantity){

        System.out.println("createOrder method called with userId: " + userId + ", productId: " + productId + ", quantity: " + quantity);
        Order order=orderService.createOrder(userId, productId, quantity);
        return ResponseEntity.ok(order);

    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<Order>> getOrderByUser(@PathVariable Long userId)
    {
        List<Order> orders=orderService.getOrderByUser(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

}
