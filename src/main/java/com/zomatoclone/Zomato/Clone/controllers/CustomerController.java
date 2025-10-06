package com.zomatoclone.Zomato.Clone.controllers;

import com.zomatoclone.Zomato.Clone.dto.*;
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

    @GetMapping("/getRestaurantMenu/{restaurant_id}")
    public ResponseEntity<List<MenuDto>> getMenuOfRestaurant(@PathVariable Long restaurant_id){
        return ResponseEntity.ok(customerService.getMenuOfRestaurant(restaurant_id));
    }

    @PostMapping("/addItemToCart")
    public ResponseEntity<ItemAddedToCartResponse> addMenuItemToCart(@RequestBody AddToCartRequest addToCartRequest){
        return ResponseEntity.ok(customerService.addMenuItemsToCart(addToCartRequest));
    }

    @GetMapping("/getCart")
    public ResponseEntity<CartResponseDto> getCartOfCustomer(){
        return ResponseEntity.ok(customerService.getCartOfCustomer());
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<SaveAddressResponseDto> saveAddressOfCustomer(@RequestBody SaveAddressRequestDto saveAddressRequestDto){
        String message = customerService.saveNewAddress(saveAddressRequestDto);
        SaveAddressResponseDto saveAddressResponseDto = SaveAddressResponseDto.builder().message(message).build();
        return ResponseEntity.ok(saveAddressResponseDto);
    }

    @DeleteMapping("/removeCartItem/{cartItemId}")
    public ResponseEntity<DeleteCartItemResponse> removeItemFromCart(@PathVariable Long cartItemId){
        customerService.removeCartItem(cartItemId);
        DeleteCartItemResponse deleteCartItemResponse = DeleteCartItemResponse.builder()
                .message("Cart itemDeletedSuccessFully").build();
        return ResponseEntity.ok(deleteCartItemResponse);
    }

    @DeleteMapping("/clearCart")
    public ResponseEntity<DeleteCartItemResponse> clearCart(){
        customerService.clearCart();
        DeleteCartItemResponse deleteCartItemResponse = DeleteCartItemResponse.builder()
                .message("Cart itemDeletedSuccessFully").build();
        return ResponseEntity.ok(deleteCartItemResponse);
    }

    @PutMapping("/increaseCartItem/{item_id}")
    public ResponseEntity<ChangeCartItemQuantityResponse> increaseCartItem(@PathVariable Long item_id){
        customerService.increaseCartItemQuantity(item_id);
        ChangeCartItemQuantityResponse changeCartItemQuantityResponse = ChangeCartItemQuantityResponse.builder()
                .message("Cart itemDeletedSuccessFully").build();
        return ResponseEntity.ok(changeCartItemQuantityResponse);
    }
    @PutMapping("/decreaseCartItem/{item_id}")
    public ResponseEntity<ChangeCartItemQuantityResponse> decreaseCartItem(@PathVariable Long item_id){
        customerService.decreaseCartItemQuantity(item_id);
        ChangeCartItemQuantityResponse changeCartItemQuantityResponse = ChangeCartItemQuantityResponse.builder()
                .message("Cart itemDeletedSuccessFully").build();
        return ResponseEntity.ok(changeCartItemQuantityResponse);
    }

}
