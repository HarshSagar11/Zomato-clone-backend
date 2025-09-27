package com.zomatoclone.Zomato.Clone.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Getter
@Setter
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

    private Long aadharNo;

    private String vehicleNo;

    @Column(columnDefinition = "geometry(Point, 4326)")
    private Point current_location;

    private boolean isAvailable;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}
