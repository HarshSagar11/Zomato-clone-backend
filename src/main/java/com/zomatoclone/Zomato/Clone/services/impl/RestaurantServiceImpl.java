package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.entities.Address;
import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import com.zomatoclone.Zomato.Clone.repositories.RestaurantRepository;
import com.zomatoclone.Zomato.Clone.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Page<Restaurant> getRestaurantsAroundAddress(Address address, PageRequest pageRequest) {
        return restaurantRepository.getRestaurantWith10KmRadius(address.getCoordinates(), pageRequest);
    }
}
