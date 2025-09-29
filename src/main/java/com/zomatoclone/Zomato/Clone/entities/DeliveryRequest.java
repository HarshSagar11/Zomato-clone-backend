package com.zomatoclone.Zomato.Clone.entities;

import com.zomatoclone.Zomato.Clone.entities.enums.DeliveryRequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryRequest {

//    id : int
//    customerOrder : customerOrder
//    distance : double
//    estimatedPreparationTime : integer
//    deliveryPaidOff : double
//    status : DeliveryRequestStatus
//    pickup : address
//    drop : address

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    private double distance;
    private int estimatedPreparationTime;
    private double deliveryFee;

    @Enumerated(value = EnumType.STRING)
    private DeliveryRequestStatus deliveryRequestStatus;

    @ManyToOne
    @JoinColumn(name = "pickup_address_id")
    private Address pickupAddress;

    @ManyToOne
    @JoinColumn(name = "drop_address_id")
    private Address dropAddress;

    @OneToOne(mappedBy = "deliveryRequest")
    private DeliveryOrder deliveryOrder;
}
