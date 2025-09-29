package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.RestaurantResponseDto;
import com.zomatoclone.Zomato.Clone.dto.SaveAddressRequestDto;
import com.zomatoclone.Zomato.Clone.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CustomerService {
    void createCustomerFromUser(User user);
    Page<RestaurantResponseDto> getNearByRestaurant(PageRequest pageRequest);

    String saveNewAddress(SaveAddressRequestDto saveAddressRequestDto);
}
