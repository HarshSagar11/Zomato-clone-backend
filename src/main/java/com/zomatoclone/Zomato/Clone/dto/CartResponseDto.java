package com.zomatoclone.Zomato.Clone.dto;

import com.zomatoclone.Zomato.Clone.entities.CartItem;
import com.zomatoclone.Zomato.Clone.entities.Customer;
import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
    private Long id;
    private List<CartItemDto> cartsItems;
    private double totalAmount;
    private RestaurantResponseDto restaurant;
}
