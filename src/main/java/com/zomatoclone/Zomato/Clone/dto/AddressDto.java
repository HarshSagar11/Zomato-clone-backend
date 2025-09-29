package com.zomatoclone.Zomato.Clone.dto;

import com.zomatoclone.Zomato.Clone.entities.Customer;
import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String completeAddress;
    private PointDto coordinates;
}
