package com.zomatoclone.Zomato.Clone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartsItems;

    @JoinColumn(name = "customer_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private double totalAmount;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
