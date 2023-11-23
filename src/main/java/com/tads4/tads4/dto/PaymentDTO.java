package com.tads4.tads4.dto;

import com.tads4.tads4.entities.Order;
import com.tads4.tads4.entities.Payment;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public class PaymentDTO {
    private Long id;

    private Instant moment;

    Order order;
    public PaymentDTO() {
    }

    public PaymentDTO(Long id, Instant moment, Order order){
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public PaymentDTO(Payment entity){
        id = entity.getId();
        moment = entity.getMoment();
        order = entity.getOrder();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment(){ return moment;}

    public Order getOrder() {return order;}
}
