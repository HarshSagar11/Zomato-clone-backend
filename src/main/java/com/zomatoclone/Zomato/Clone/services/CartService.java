package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.AddToCartRequest;
import com.zomatoclone.Zomato.Clone.entities.Cart;
import com.zomatoclone.Zomato.Clone.entities.Customer;

public interface CartService {
    Cart createNewCart(Customer customer);

    void addItemToCartOfCustomer(Long customerId, AddToCartRequest addToCartRequest);
}
