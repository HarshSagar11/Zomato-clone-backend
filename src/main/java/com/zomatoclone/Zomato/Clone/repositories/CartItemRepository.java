package com.zomatoclone.Zomato.Clone.repositories;

import com.zomatoclone.Zomato.Clone.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
