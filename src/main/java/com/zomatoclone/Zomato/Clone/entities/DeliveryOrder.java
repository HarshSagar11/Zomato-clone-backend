package com.zomatoclone.Zomato.Clone.entities;

import com.zomatoclone.Zomato.Clone.entities.enums.DeliveryRequestStatus;
import com.zomatoclone.Zomato.Clone.entities.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_request_id")
    private DeliveryRequest deliveryRequest;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "delivery_partner_id")
    private DeliveryPartner deliveryPartner;

    private Date pickupTime;
    private Date dropOffTime;

}
