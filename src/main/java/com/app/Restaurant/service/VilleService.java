package com.app.Restaurant.service;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.Ville;
import com.app.Restaurant.POJO.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VilleService {
    ResponseEntity<List<Ville>> getAllVille();
    ResponseEntity<Ville> getVilleById(int id);
    ResponseEntity<?> createVille(Ville ville);
    ResponseEntity<?> updateVille(int id, Ville ville);
    ResponseEntity<?> deleteVille(int id);
    ResponseEntity<List<Zone>> getAllZonesForVille(String ville);

    ResponseEntity<List<Restaurant>> getAllRestaurantsForZone(String ville, String zone);
    ResponseEntity<?> getAllRestaurantsForZoneAndSpecialite(String ville,String zone,String speceialite);
    ResponseEntity<List<Restaurant>> getAllRestaurantsForZoneAndSerie(String ville,String zone,String serie);
    ResponseEntity<?> getRestaurantForZoneAndId(String ville,String zone,int id);
    ResponseEntity<?> getRestaurantitineraire(String ville,String zone,int id);
}
