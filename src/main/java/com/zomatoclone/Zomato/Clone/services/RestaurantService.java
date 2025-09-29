package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.entities.Address;
import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RestaurantService {
    Page<Restaurant> getRestaurantsAroundAddress(Address address, PageRequest pageRequest);
}
