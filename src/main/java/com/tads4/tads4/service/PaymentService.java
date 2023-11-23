package com.tads4.tads4.service;

import com.tads4.tads4.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {
    @Autowired
    private PaymentRepository repository;
}
