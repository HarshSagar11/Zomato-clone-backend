package com.zomatoclone.Zomato.Clone.dto;

import com.zomatoclone.Zomato.Clone.entities.enums.MenuItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDto {
    private Long id;
    private String name;
    private String description;
    private MenuItemType type;
    private Double rating;
    private double price;
    private boolean isAvailable;
}
