package com.zomatoclone.Zomato.Clone.repositories;

import com.zomatoclone.Zomato.Clone.entities.Restaurant;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query(value = "SELECT r.*, ST_Distance(a.coordinates, :point) AS distance " +
            "FROM restaurant r " +
            "JOIN address a " +
            "ON r.address_id = a.id " +
            "WHERE r.is_open = true " +
            "AND ST_DWithin(a.coordinates, :point, 10000) " +
            "ORDER BY distance ASC, r.rating ASC", nativeQuery = true)
    Page<Restaurant> getRestaurantWith10KmRadius(Point point, PageRequest pageRequest);
}
