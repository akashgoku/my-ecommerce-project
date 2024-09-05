package com.example.ecommerce.product_service.service;


import com.example.ecommerce.product_service.entity.Order;
import com.example.ecommerce.product_service.entity.Payment;
import com.example.ecommerce.product_service.repository.OrderRepository;
import com.example.ecommerce.product_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment processPayment(Long orderId)
    {
        // Generate a mock transaction ID and simulate a successful payment
        String transactionId= UUID.randomUUID().toString();

        Payment payment=new Payment();

        payment.setTransactionId(transactionId);
        payment.setOrderId(orderId);
        payment.setPaymentStatus("SUCCESS");
        payment.setPaymentDate(LocalDateTime.now());


        Payment savedPayment= paymentRepository.save(payment);

        Order order=orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("Order Not Found"));
        order.setPaymentStatus(savedPayment.getPaymentStatus());
        order.setStatus("COMPLETED"); // or keep it as "PENDING" until shipped
        orderRepository.save(order);

        return savedPayment;
    }

    public Payment getPaymentDetails(String transactionId)
    {
        return paymentRepository.findByTransactionId(transactionId);
    }
}
