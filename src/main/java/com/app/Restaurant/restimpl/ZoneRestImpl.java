package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Zone;
import com.app.Restaurant.rest.ZoneRest;
import com.app.Restaurant.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZoneRestImpl implements ZoneRest {
    @Autowired
    ZoneService zoneService;
    @Override
    public ResponseEntity<List<Zone>> getAllZones() {
        try {
            return zoneService.getAllZones();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Zone>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Zone> getZoneById(int id) {
        try {
            return zoneService.getZoneById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createZone(Zone zone) {
        try {
            return zoneService.createZone(zone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateZone(int id, Zone zone) {
        try {
            return zoneService.updateZone(id,zone);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteZone(int id) {
        try {
            return zoneService.deleteZone(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
