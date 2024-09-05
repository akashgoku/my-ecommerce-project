package com.example.ecommerce.product_service.service;


import com.example.ecommerce.product_service.entity.Order;
import com.example.ecommerce.product_service.entity.Product;
import com.example.ecommerce.product_service.entity.User;
import com.example.ecommerce.product_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public Order createOrder(Long userId, Long productId, Integer quantity)
    {
        User user = userService.findById(userId); //fetch user
        Product product= productService.getProductById(productId);  //fetch product
        BigDecimal totalPrice=product.getPrice().multiply(BigDecimal.valueOf(quantity));  //calculate total price

        Order order=new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setTotalPrice(totalPrice);
        order.setQuantity(quantity);
        order.setStatus("PENDING");  //Default Status
        return orderRepository.save(order);
    }

    public List<Order> getOrderByUser(Long userId)
    {
        return orderRepository.findAllByUserId(userId);
    }

    public Order getOrderById(Long id)
    {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found")); //handle order not found
    }
}
