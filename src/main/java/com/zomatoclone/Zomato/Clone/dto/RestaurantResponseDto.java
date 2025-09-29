package com.zomatoclone.Zomato.Clone.dto;

import com.zomatoclone.Zomato.Clone.entities.Address;
import com.zomatoclone.Zomato.Clone.entities.enums.RestaurantTypes;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {

    private Long id;
    private String name;

    private double rating;

    private AddressDto address;

    private RestaurantTypes restaurantType;

    private String description;

    private boolean isOpen;


}
