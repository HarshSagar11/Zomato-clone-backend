package com.zomatoclone.Zomato.Clone.entities;

import com.zomatoclone.Zomato.Clone.entities.enums.MenuItemType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private MenuItemType type;

    private Double rating;

    private double price;

    private boolean isAvailable;

    @JoinColumn(name = "menu_id")
    @ManyToOne
    private Menu menu;

}
