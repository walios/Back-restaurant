package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.RestaurantSpecialite;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/restaurant-specialites")
public interface RestaurantSpecialiteRest {

    @GetMapping(path ="/")
    ResponseEntity<List<RestaurantSpecialite>> getAllRestaurantSpecialites();

    @GetMapping(path ="/{id}")
    ResponseEntity<RestaurantSpecialite> getRestaurantSpecialiteById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createRestaurantSpecialite(@RequestBody RestaurantSpecialite restaurantSpecialite);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateRestaurantSpecialite(@PathVariable int id, @RequestBody RestaurantSpecialite restaurantSpecialite);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteRestaurantSpecialite(@PathVariable int id);
}
