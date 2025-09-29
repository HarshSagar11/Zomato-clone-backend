package com.zomatoclone.Zomato.Clone.controllers;

import com.zomatoclone.Zomato.Clone.dto.RestaurantResponseDto;
import com.zomatoclone.Zomato.Clone.dto.SaveAddressRequestDto;
import com.zomatoclone.Zomato.Clone.dto.SaveAddressResponseDto;
import com.zomatoclone.Zomato.Clone.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@Secured("ROLE_CUSTOMER")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/restaurants")
    public ResponseEntity<List<RestaurantResponseDto>> getNearbyRestaurant(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(customerService.getNearByRestaurant(pageRequest).getContent());
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<SaveAddressResponseDto> saveAddressOfCustomer(@RequestBody SaveAddressRequestDto saveAddressRequestDto){
        String message = customerService.saveNewAddress(saveAddressRequestDto);
        SaveAddressResponseDto saveAddressResponseDto = SaveAddressResponseDto.builder().message(message).build();
        return ResponseEntity.ok(saveAddressResponseDto);
    }



}
