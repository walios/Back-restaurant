package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.RestaurantSpecialite;
import com.app.Restaurant.rest.RestaurantSpecialiteRest;
import com.app.Restaurant.service.RestaurantSpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantSpecialiteRestImpl implements RestaurantSpecialiteRest {
    @Autowired
    RestaurantSpecialiteService restaurantSpecialiteService;

    @Override
    public ResponseEntity<List<RestaurantSpecialite>> getAllRestaurantSpecialites() {
        try {
            return restaurantSpecialiteService.getAllRestaurantSpecialites();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<RestaurantSpecialite>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<RestaurantSpecialite> getRestaurantSpecialiteById(int id) {
        try {
            return restaurantSpecialiteService.getRestaurantSpecialiteById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createRestaurantSpecialite(RestaurantSpecialite restaurantSpecialite) {
        try {
            return restaurantSpecialiteService.createRestaurantSpecialite(restaurantSpecialite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateRestaurantSpecialite(int id, RestaurantSpecialite restaurantSpecialite) {
        try {
            return restaurantSpecialiteService.updateRestaurantSpecialite(id, restaurantSpecialite);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteRestaurantSpecialite(int id) {
        try {
            return restaurantSpecialiteService.deleteRestaurantSpecialite(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
