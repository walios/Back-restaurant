package com.app.Restaurant.service;

import com.app.Restaurant.POJO.RestaurantSpecialite;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantSpecialiteService {
    ResponseEntity<List<RestaurantSpecialite>> getAllRestaurantSpecialites();
    ResponseEntity<RestaurantSpecialite> getRestaurantSpecialiteById(int id);
    ResponseEntity<?> createRestaurantSpecialite(RestaurantSpecialite restaurantSpecialite);
    ResponseEntity<?> updateRestaurantSpecialite(int id, RestaurantSpecialite restaurantSpecialite);
    ResponseEntity<?> deleteRestaurantSpecialite(int id);
}
