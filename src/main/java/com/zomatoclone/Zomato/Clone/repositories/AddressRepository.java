package com.zomatoclone.Zomato.Clone.repositories;

import com.zomatoclone.Zomato.Clone.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
