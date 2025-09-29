package com.zomatoclone.Zomato.Clone.entities;

import com.zomatoclone.Zomato.Clone.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_request_id")
    private OrderRequest orderRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

}
