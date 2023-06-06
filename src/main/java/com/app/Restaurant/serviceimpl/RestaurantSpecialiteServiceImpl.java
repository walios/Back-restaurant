package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.RestaurantSpecialite;
import com.app.Restaurant.dao.RestaurantSpecialiteDao;
import com.app.Restaurant.service.RestaurantSpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantSpecialiteServiceImpl implements RestaurantSpecialiteService {
    @Autowired
    private RestaurantSpecialiteDao restaurantSpecialiteDao;

    @Override
    public ResponseEntity<List<RestaurantSpecialite>> getAllRestaurantSpecialites() {
        try {
            return new ResponseEntity<>(restaurantSpecialiteDao.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<RestaurantSpecialite>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<RestaurantSpecialite> getRestaurantSpecialiteById(int id) {
        try {
            return new ResponseEntity<>(restaurantSpecialiteDao.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createRestaurantSpecialite(RestaurantSpecialite restaurantSpecialite) {
        try {
            restaurantSpecialiteDao.save(restaurantSpecialite);
            return new ResponseEntity<>("RestaurantSpecialite Created Successfully", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateRestaurantSpecialite(int id, RestaurantSpecialite restaurantSpecialite) {
        try {
            RestaurantSpecialite oldRestaurantSpecialite = restaurantSpecialiteDao.findById(id);
            oldRestaurantSpecialite.setRestaurant(restaurantSpecialite.getRestaurant());
            oldRestaurantSpecialite.setSpecialite(restaurantSpecialite.getSpecialite());
            restaurantSpecialiteDao.save(oldRestaurantSpecialite);
            return new ResponseEntity<>("RestaurantSpecialite Updated Successfully", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteRestaurantSpecialite(int id) {
        try {
            restaurantSpecialiteDao.deleteById(id);
            return new ResponseEntity<>("RestaurantSpecialite Deleted Successfully", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<RestaurantSpecialite>(new RestaurantSpecialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}