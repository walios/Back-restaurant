package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantDao extends JpaRepository<Restaurant,Integer> {
    List<Restaurant> findByZones(Zone zoneObject);
    Restaurant findById(int id);
    List<Restaurant>findBySeriesNom(String serie);
}
