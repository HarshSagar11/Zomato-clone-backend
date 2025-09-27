package com.zomatoclone.Zomato.Clone.entities;

import com.zomatoclone.Zomato.Clone.entities.enums.RestaurantTypes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private double rating;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Enumerated(value = EnumType.STRING)
    private RestaurantTypes restaurantType;

    private String description;

    private boolean isOpen;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menu;

    @OneToOne(mappedBy = "restaurant")
    private RestaurantAdmin admin;

    //TODO add orders
    
}
