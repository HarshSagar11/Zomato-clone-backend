package com.zomatoclone.Zomato.Clone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "admin")
    private List<DeliveryPartner> onBoardedDeliverPartners;

    @OneToMany(mappedBy = "addedBy")
    private List<RestaurantAdmin> onBoardedRestaurantAdmins;


}
