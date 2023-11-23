package com.tads4.tads4.entities;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatus status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

   @ManyToOne
   @JoinColumn(name = "client_id")
    private User client;

   @OneToMany(mappedBy = "id.order")
   private Set<OrderItem> items = new HashSet<>();
    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus satus, User client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getSatus() {
        return status;
    }

    public void setSatus(OrderStatus satus) {
        this.status = satus;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Product> getProducts(){
        return items.stream().map(x -> x.getProduct()).toList();
    }
}
