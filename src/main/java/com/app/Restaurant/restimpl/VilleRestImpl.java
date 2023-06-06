package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.Ville;
import com.app.Restaurant.POJO.Zone;
import com.app.Restaurant.rest.VilleRest;
import com.app.Restaurant.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class VilleRestImpl implements VilleRest {
    @Autowired
    VilleService villeService;

    public ResponseEntity<List<Ville>> getAllVille() {
        try {
            return villeService.getAllVille();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Ville>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Ville> getVilleById(int id) {
        try {
            return villeService.getVilleById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createVille(Ville ville) {
        try {
            return villeService.createVille(ville);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateVille(int id, Ville ville) {
        try {
            return villeService.updateVille(id,ville);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteVille(int id) {
        try {
            return villeService.deleteVille(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Ville>(new Ville(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<List<Zone>> getAllZonesForVille(String ville) {
        try {
            return villeService.getAllZonesForVille(ville);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Zone>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Restaurant>> getAllRestaurantsForZone(String ville, String zone) {
        try {
            return villeService.getAllRestaurantsForZone(ville, zone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Restaurant>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getAllRestaurantsForZoneAndSpecialite(String ville, String zone, String specialite) {
        try {
            return villeService.getAllRestaurantsForZoneAndSpecialite(ville,zone,specialite);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Restaurant>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Restaurant>> getAllRestaurantsForZoneAndSerie(String ville, String zone, String serie) {
        try {
            return villeService.getAllRestaurantsForZoneAndSerie(ville,zone,serie);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Restaurant>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getRestaurantForZoneAndId(String ville, String zone, int id) {
        try {
            return villeService.getRestaurantForZoneAndId(ville,zone,id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new Restaurant(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> getRestaurantitineraire(String ville, String zone, int id) {
        try {
            return villeService.getRestaurantitineraire(ville,zone,id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new Restaurant(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
