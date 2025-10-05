package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.entities.CartItem;
import com.zomatoclone.Zomato.Clone.repositories.CartItemRepository;
import com.zomatoclone.Zomato.Clone.services.CartItemService;
import com.zomatoclone.Zomato.Clone.services.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public CartItem createNewCartitem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
}
