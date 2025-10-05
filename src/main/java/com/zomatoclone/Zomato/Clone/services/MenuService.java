package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.entities.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getMenuOfRestaurant(Long restaurantId);
}
