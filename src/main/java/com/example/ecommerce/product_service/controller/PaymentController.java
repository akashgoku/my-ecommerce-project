package com.example.ecommerce.product_service.controller;


import com.example.ecommerce.product_service.entity.Payment;
import com.example.ecommerce.product_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public Payment processPayment(@RequestParam Long orderId)
    {
            return paymentService.processPayment(orderId);
    }

    @GetMapping("/{transactionId}")
    public Payment getPaymentDetails(@PathVariable String transactioId)
    {
        return paymentService.getPaymentDetails(transactioId);
    }
}
