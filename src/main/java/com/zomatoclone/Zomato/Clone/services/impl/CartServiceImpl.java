package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.AddToCartRequest;
import com.zomatoclone.Zomato.Clone.entities.Cart;
import com.zomatoclone.Zomato.Clone.entities.CartItem;
import com.zomatoclone.Zomato.Clone.entities.Customer;
import com.zomatoclone.Zomato.Clone.entities.MenuItem;
import com.zomatoclone.Zomato.Clone.exceptions.BadRequestException;
import com.zomatoclone.Zomato.Clone.repositories.CartRepository;
import com.zomatoclone.Zomato.Clone.services.CartItemService;
import com.zomatoclone.Zomato.Clone.services.CartService;
import com.zomatoclone.Zomato.Clone.services.MenuItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final MenuItemService menuItemService;
    private final CartItemService cartItemService;

    @Override
    public Cart createNewCart(Customer customer) {
        Cart cart = new Cart();
        cart.setCustomer(customer);
        return cartRepository.save(cart);
    }

    @Override
    public void addItemToCartOfCustomer(Long customerId, AddToCartRequest addToCartRequest) {
        Cart cart = cartRepository.findByCustomerId(customerId);
        Optional<CartItem> existingCartItem = cart.getCartsItems().stream()
                .filter(item -> item.getMenuItem().getId().equals(addToCartRequest.getMenuItemId()))
                .findFirst();
        if(existingCartItem.isPresent()){
            throw new BadRequestException("This item is already present in cart");
        }
        MenuItem menuItem = menuItemService.getMenuItemByIdToAddInCart(addToCartRequest.getMenuItemId());
        Long menuRestaurantId = menuItem.getMenu().getRestaurant().getId();
        if(cart.getRestaurant() != null && !cart.getRestaurant().getId().equals(menuRestaurantId)){
            throw new BadRequestException("Cart has item of restaurant id : " + cart.getRestaurant().getId()
                    +" but menu item has restaurant id : "+ menuRestaurantId);
        }
        if(cart.getRestaurant() == null){
            cart.setRestaurant(menuItem.getMenu().getRestaurant());
        }
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setMenuItem(menuItem);
        cartItem.setQuantity(addToCartRequest.getQuantity());
        cart.getCartsItems().add(cartItem);
        cart.setTotalAmount(cart.getTotalAmount() + (menuItem.getPrice()*addToCartRequest.getQuantity()));
        cartRepository.save(cart);
    }
}
