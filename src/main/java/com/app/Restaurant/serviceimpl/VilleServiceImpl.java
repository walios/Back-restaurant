package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.RestaurantSpecialite;
import com.app.Restaurant.POJO.Ville;
import com.app.Restaurant.POJO.Zone;
import com.app.Restaurant.RestaurantApplication;
import com.app.Restaurant.constents.RestaurantConstant;
import com.app.Restaurant.dao.RestaurantDao;
import com.app.Restaurant.dao.RestaurantSpecialiteDao;
import com.app.Restaurant.dao.VilleDao;
import com.app.Restaurant.dao.ZoneDao;
import com.app.Restaurant.service.VilleService;
import com.app.Restaurant.utils.RestaurantUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.json.*;

@Slf4j
@Service
public class VilleServiceImpl implements VilleService{
    @Autowired
    VilleDao villeDao;
    @Autowired
    ZoneDao zoneDao;
    @Autowired
    RestaurantSpecialiteDao restaurantSpecialiteDao;
    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public ResponseEntity<List<Ville>> getAllVille() {
        try {
            return new ResponseEntity<>(villeDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Ville> getVilleById(int id) {
        try {
            return new ResponseEntity<>(villeDao.findById(id), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createVille(Ville ville) {
        try {
            villeDao.save(ville);
            return new ResponseEntity<>("Ville Created Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateVille(int id, Ville ville) {
        try {
            Ville oldVille = villeDao.findById(id);
            oldVille.setNom(ville.getNom());
            oldVille.setZones(ville.getZones());
            villeDao.save(oldVille);
            return new ResponseEntity<>("Ville Updated Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteVille(int id) {
        try {
            villeDao.deleteById(id);
            return new ResponseEntity<>("Ville Deleted Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>("SOMETHING WENT WRONG",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<Zone>>getAllZonesForVille(String city) {
        try {
            Ville ville = villeDao.findByNom(city);
            if (ville==null){
                return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<>(ville.getZones(),HttpStatus.OK);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Restaurant>> getAllRestaurantsForZone(String ville, String zone) {
        try {
            Zone zoneObject = zoneDao.findByNomAndVilleNom(zone, ville);
            List<Restaurant> restaurants = restaurantDao.findByZones(zoneObject);
            return new ResponseEntity<>(restaurants,HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getAllRestaurantsForZoneAndSpecialite(String ville, String zone, String speceialite) {
        List<Restaurant> result_restaurants = new ArrayList<>();
        List<RestaurantSpecialite> restaurantSpecialites = restaurantSpecialiteDao.findBySpecialite_Nom(speceialite);
        Optional<Zone> matchedZone = zoneDao.findByNomAndVille_Nom(zone, ville);
        if (matchedZone.isPresent()) {
            for (RestaurantSpecialite pg : restaurantSpecialites) {
                Restaurant result_restaurant= pg.getRestaurant();
                if (result_restaurant.getZones() == matchedZone.get()) {
                    result_restaurants.add(result_restaurant);
                }
            }
            return new ResponseEntity<>(result_restaurants,HttpStatus.OK);
        }

        else
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Restaurant>> getAllRestaurantsForZoneAndSerie(String ville, String zone, String serie) {
        try {
            Zone zoneObject = zoneDao.findByNomAndVilleNom(zone, ville);
            List<Restaurant> restaurants_serie = restaurantDao.findBySeriesNom(serie);
            List<Restaurant> restaurants_zone = restaurantDao.findByZones(zoneObject);
            List<Restaurant> commonRestaurants = new ArrayList<>();
            for (Restaurant rest : restaurants_zone){
                if (restaurants_serie.contains(rest)) {
                    commonRestaurants.add(rest);
                }
            }
            return new ResponseEntity<>(commonRestaurants,HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getRestaurantForZoneAndId(String ville, String zone, int id) {
        try {
            Restaurant restaurant = restaurantDao.findById(id);
            return new ResponseEntity<>(restaurant,HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new Restaurant(),HttpStatus.BAD_REQUEST );
    }

    @Override
    public ResponseEntity<?> getRestaurantitineraire(String ville, String zone, int id) {
        try {

            Restaurant restaurant = restaurantDao.findById(id);
            double endlong = Double.parseDouble(restaurant.getLongtitude());
            double endlat = Double.parseDouble(restaurant.getLattitude());
            double [] position = {31.6260606,-7.9929946,endlong,endlat};
            String jsonData = RestaurantApplication.apiService.getJsonDataFromApi(position);
            return new ResponseEntity<>(jsonData,HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  new ResponseEntity<>(new Restaurant(),HttpStatus.BAD_REQUEST);
    }

}
