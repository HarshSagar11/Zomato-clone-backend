package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.AddToCartRequest;
import com.zomatoclone.Zomato.Clone.entities.Cart;
import com.zomatoclone.Zomato.Clone.entities.Customer;

public interface CartService {
    Cart createNewCart(Customer customer);

    void addItemToCartOfCustomer(Customer customer, AddToCartRequest addToCartRequest);

    void removeItemFromCart(Long cartItemId, Customer customer);

    void clearCart(Customer customer);

    void incrementCartItemQuantity(Customer customer, Long CartItemId);

    void decrementCartItemQuantity(Customer customer, Long CartItemId);
}
