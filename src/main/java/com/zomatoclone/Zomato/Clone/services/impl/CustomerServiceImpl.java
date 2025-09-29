package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.RestaurantResponseDto;
import com.zomatoclone.Zomato.Clone.dto.SaveAddressRequestDto;
import com.zomatoclone.Zomato.Clone.entities.Address;
import com.zomatoclone.Zomato.Clone.entities.Customer;
import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import com.zomatoclone.Zomato.Clone.entities.User;
import com.zomatoclone.Zomato.Clone.exceptions.BadRequestException;
import com.zomatoclone.Zomato.Clone.exceptions.ResourceNotFoundException;
import com.zomatoclone.Zomato.Clone.repositories.CustomerRepository;
import com.zomatoclone.Zomato.Clone.services.AddressService;
import com.zomatoclone.Zomato.Clone.services.CustomerService;
import com.zomatoclone.Zomato.Clone.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final RestaurantService restaurantService;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final AddressService addressService;

    @Override
    public void createCustomerFromUser(User user) {
        Customer customer = new Customer();
        customer.setUser(user);
        customer.setRating(0d);
        customerRepository.save(customer);
    }

    @Override
    public Page<RestaurantResponseDto> getNearByRestaurant(PageRequest pageRequest) {
        Customer customer = getCurrentCustomer();
        Address address = customer.getAddress();
        if(address == null){
            throw new ResourceNotFoundException("Address not found with customerId : " + customer.getId());
        }
        Page<Restaurant> restaurants = restaurantService.getRestaurantsAroundAddress(address,pageRequest);
        return restaurants.map(
                restaurant -> modelMapper.map(restaurant,RestaurantResponseDto.class)
        );
    }

    @Override
    public String saveNewAddress(SaveAddressRequestDto saveAddressRequestDto) {
        Customer customer = getCurrentCustomer();
        Address address = addressService.saveNewAddress(saveAddressRequestDto);
        if(address == null){
            throw new BadRequestException("There is some issue saving the address for customer id : " + customer.getId());
        }
        customer.setAddress(address);
        customerRepository.save(customer);
        return "Address saved successfully";
    }

    private Customer getCurrentCustomer(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customerRepository.findByUserId(user.getId()).orElseThrow(()->
                new ResourceNotFoundException("Customer not found with this user id :" + user.getId())
                );
    }
}
