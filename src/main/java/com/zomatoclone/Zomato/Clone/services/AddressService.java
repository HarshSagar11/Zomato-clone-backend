package com.zomatoclone.Zomato.Clone.services;

import com.zomatoclone.Zomato.Clone.dto.SaveAddressRequestDto;
import com.zomatoclone.Zomato.Clone.entities.Address;

public interface AddressService {
    Address saveNewAddress(Address address);
    Address saveNewAddress(SaveAddressRequestDto saveAddressRequestDto);
}
