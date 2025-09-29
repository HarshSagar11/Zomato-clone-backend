package com.zomatoclone.Zomato.Clone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveAddressRequestDto {

    private String completeAddress;
    private double latitude;
    private double longitude;
}
