package com.app.Restaurant.service;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.POJO.Restaurant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantService {

    ResponseEntity<List<Restaurant>> getAllRestaurants();
    ResponseEntity<Restaurant> getRestaurantById(int id);
    ResponseEntity<?> createRestaurant(Restaurant restaurant);
    ResponseEntity<?> updateRestaurant(int id, Restaurant restaurant);
    ResponseEntity<?> deleteRestaurant(int id);
}
