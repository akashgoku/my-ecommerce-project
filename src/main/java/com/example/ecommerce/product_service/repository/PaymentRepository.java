package com.example.ecommerce.product_service.repository;

import com.example.ecommerce.product_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByTransactionId(String transactionId);

}
