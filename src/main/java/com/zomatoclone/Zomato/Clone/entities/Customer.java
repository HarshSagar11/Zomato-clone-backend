package com.zomatoclone.Zomato.Clone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private Double rating;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    //TODO : add orders here
}
