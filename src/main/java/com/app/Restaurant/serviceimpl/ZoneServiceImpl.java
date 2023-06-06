package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Zone;
import com.app.Restaurant.dao.ZoneDao;
import com.app.Restaurant.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    private ZoneDao zoneDao;
    @Override
    public ResponseEntity<List<Zone>> getAllZones() {
        try {
            return new ResponseEntity<>(zoneDao.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Zone>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Zone> getZoneById(int id) {
        try {
            return new ResponseEntity<>(zoneDao.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createZone(Zone zone) {
        try {
            zoneDao.save(zone);
            return new ResponseEntity<>("Zone Created Succesfully", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateZone(int id, Zone zone) {
        try {
            Zone oldZone = zoneDao.findById(id);
            oldZone.setNom(zone.getNom());
            oldZone.setRests(zone.getRests());
            oldZone.setVille(zone.getVille());
            zoneDao.save(oldZone);
            return new ResponseEntity<>("Zone Updated Succesfully", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteZone(int id) {
        try {
            zoneDao.deleteById(id);
            return new ResponseEntity<>("Zone Deleted Succesfully", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Zone>(new Zone(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
