package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.rest.PhotoRest;
import com.app.Restaurant.rest.RestaurantRest;
import com.app.Restaurant.service.PhotoService;
import com.app.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantRestImpl implements RestaurantRest{
    @Autowired
    RestaurantService restaurantService;
    @Override
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        try {
            return restaurantService.getAllRestaurants();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Restaurant>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Restaurant> getRestaurantById(int id) {
        try {
            return restaurantService.getRestaurantById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createRestaurant(Restaurant restaurant) {
        try {
            return restaurantService.createRestaurant(restaurant);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateRestaurant(int id, Restaurant restaurant) {
        try {
            return restaurantService.updateRestaurant(id,restaurant);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteRestaurant(int id) {
        try {
            return restaurantService.deleteRestaurant(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
