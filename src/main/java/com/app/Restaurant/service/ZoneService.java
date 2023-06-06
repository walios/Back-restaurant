package com.app.Restaurant.service;

import com.app.Restaurant.POJO.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZoneService {
    ResponseEntity<List<Zone>> getAllZones();
    ResponseEntity<Zone> getZoneById(int id);
    ResponseEntity<?> createZone(Zone zone);
    ResponseEntity<?> updateZone(int id, Zone zone);
    ResponseEntity<?> deleteZone(int id);

}
