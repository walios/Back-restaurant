package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.dao.PhotoDao;
import com.app.Restaurant.dao.RestaurantDao;
import com.app.Restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;
    @Override
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        try {
            return new ResponseEntity<>(restaurantDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Restaurant>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Restaurant> getRestaurantById(int id) {
        try {
            return new ResponseEntity<>(restaurantDao.findById(id), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createRestaurant(Restaurant restaurant) {
        try {
            restaurantDao.save(restaurant);
            return new ResponseEntity<>("Restaurant Created Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateRestaurant(int id, Restaurant restaurant) {
        try {
            Restaurant oldRestaurant = restaurantDao.findById(id);
            oldRestaurant.setAdresse(restaurant.getAdresse());
            oldRestaurant.setNom(restaurant.getNom());
            oldRestaurant.setClose(restaurant.getClose());
            oldRestaurant.setOpen(restaurant.getOpen());
            oldRestaurant.setLattitude(restaurant.getLattitude());
            oldRestaurant.setLongtitude(restaurant.getLongtitude());
            oldRestaurant.setPhotos(restaurant.getPhotos());
            oldRestaurant.setRank(restaurant.getRank());
            oldRestaurant.setSeries(restaurant.getSeries());
            oldRestaurant.setRestaurantspecialite(restaurant.getRestaurantspecialite());
            oldRestaurant.setUser(restaurant.getUser());
            oldRestaurant.setWeekend(restaurant.getWeekend());
            oldRestaurant.setZones(restaurant.getZones());
            restaurantDao.save(oldRestaurant);
            return new ResponseEntity<>("Restaurant Updated Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteRestaurant(int id) {
        try {
            restaurantDao.deleteById(id);
            return new ResponseEntity<>("Restaurant Deleted Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Restaurant>(new Restaurant(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
