package com.zomatoclone.Zomato.Clone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequest {
    private Long restaurantId;
    private Long menuItemId;
    private int quantity;
}
