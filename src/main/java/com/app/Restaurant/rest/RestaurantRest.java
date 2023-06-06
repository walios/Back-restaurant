package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.POJO.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/restaurants")
public interface RestaurantRest {

    @GetMapping(path ="/")
    ResponseEntity<List<Restaurant>> getAllRestaurants();

    @GetMapping(path ="/{id}")
    ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteRestaurant(@PathVariable int id);
}