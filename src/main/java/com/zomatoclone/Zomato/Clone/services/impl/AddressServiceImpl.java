package com.zomatoclone.Zomato.Clone.services.impl;

import com.zomatoclone.Zomato.Clone.dto.PointDto;
import com.zomatoclone.Zomato.Clone.dto.SaveAddressRequestDto;
import com.zomatoclone.Zomato.Clone.entities.Address;
import com.zomatoclone.Zomato.Clone.repositories.AddressRepository;
import com.zomatoclone.Zomato.Clone.services.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public Address saveNewAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address saveNewAddress(SaveAddressRequestDto saveAddressRequestDto) {
        double[] coordinates = {
                saveAddressRequestDto.getLongitude(),
                saveAddressRequestDto.getLatitude()
        };
        PointDto pointDto = PointDto.builder()
                        .coordinates(coordinates)
                                .build();
        try{
            Point point = modelMapper.map(pointDto, Point.class);
            Address address = new Address();
            address.setCompleteAddress(saveAddressRequestDto.getCompleteAddress());
            address.setCoordinates(point);
            return addressRepository.save(address);
        }
        catch(Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }
}
