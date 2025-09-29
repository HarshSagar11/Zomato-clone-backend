package com.zomatoclone.Zomato.Clone.entities;

import com.zomatoclone.Zomato.Clone.entities.enums.OrderRequestStatus;
import com.zomatoclone.Zomato.Clone.entities.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private double deliveryFee;
    private double totalAmount;
    private double platformFee;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToOne(mappedBy = "orderRequest")
    private CustomerOrder customerOrder;

    @Enumerated(value = EnumType.STRING)
    private OrderRequestStatus status;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMethod;
}
