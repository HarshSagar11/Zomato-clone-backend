package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.*;
import com.zomatoclone.Zomato.Clone.entities.*;
import com.zomatoclone.Zomato.Clone.exceptions.BadRequestException;
import com.zomatoclone.Zomato.Clone.exceptions.ResourceNotFoundException;
import com.zomatoclone.Zomato.Clone.exceptions.ServiceUnavailableException;
import com.zomatoclone.Zomato.Clone.repositories.CustomerRepository;
import com.zomatoclone.Zomato.Clone.services.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final RestaurantService restaurantService;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final AddressService addressService;
    private final MenuService menuService;
    private final CartService cartService;

    @Override
    public void createCustomerFromUser(User user) {
        log.info("Saving Customer with user id :{}", user.getId());
        Customer customer = new Customer();
        customer.setUser(user);
        customer.setRating(0d);
        Customer savedCustomer = customerRepository.save(customer);
        cartService.createNewCart(savedCustomer);
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

    @Override
    public List<MenuDto> getMenuOfRestaurant(Long restaurantId) {
        List<Menu> menus = menuService.getMenuOfRestaurant(restaurantId);
        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDto.class))
                .toList();
    }

    @Override
    public ItemAddedToCartResponse addMenuItemsToCart(AddToCartRequest addToCartRequest) {
        Customer customer = this.getCurrentCustomer();
        cartService.addItemToCartOfCustomer(customer.getId(), addToCartRequest);
        return ItemAddedToCartResponse.builder().message("Item Added to cart Successfully").build();
    }

    @Override
    public CartResponseDto getCartOfCustomer() {
        Customer customer = this.getCurrentCustomer();
        Cart cart = customer.getCart();
        return modelMapper.map(cart,CartResponseDto.class);
    }

    private Customer getCurrentCustomer(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customerRepository.findByUserId(user.getId()).orElseThrow(()->
                new ResourceNotFoundException("Customer not found with this user id :" + user.getId())
                );
    }
}
