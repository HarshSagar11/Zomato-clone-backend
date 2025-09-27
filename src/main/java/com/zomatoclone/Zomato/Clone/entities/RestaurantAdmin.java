package com.zomatoclone.Zomato.Clone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RestaurantAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    private Long aadharNo;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin addedBy;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
