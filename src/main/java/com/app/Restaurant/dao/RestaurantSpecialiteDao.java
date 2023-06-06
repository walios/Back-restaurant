package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.RestaurantSpecialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantSpecialiteDao extends JpaRepository<RestaurantSpecialite,Integer> {
    List<RestaurantSpecialite> findBySpecialite_Nom(String speceialite);
    RestaurantSpecialite findById(int id);
}
