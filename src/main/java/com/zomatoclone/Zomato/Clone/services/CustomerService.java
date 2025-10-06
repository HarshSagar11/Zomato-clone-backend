package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.*;
import com.zomatoclone.Zomato.Clone.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CustomerService {
    void createCustomerFromUser(User user);
    Page<RestaurantResponseDto> getNearByRestaurant(PageRequest pageRequest);

    String saveNewAddress(SaveAddressRequestDto saveAddressRequestDto);

    List<MenuDto> getMenuOfRestaurant(Long restaurantId);

    ItemAddedToCartResponse addMenuItemsToCart(AddToCartRequest addToCartRequest);

    CartResponseDto getCartOfCustomer();

    void removeCartItem(Long cartItemId);

    void clearCart();

    void decreaseCartItemQuantity(Long cartItemId);

    void increaseCartItemQuantity(Long cartItemId);
}
