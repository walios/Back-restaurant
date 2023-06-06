package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Specialite;
import com.app.Restaurant.dao.SpecialiteDao;
import com.app.Restaurant.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialiteServiceImpl implements SpecialiteService {
    @Autowired
    private SpecialiteDao specialiteDao;
    @Override
    public ResponseEntity<List<Specialite>> getAllSpecialites() {
        try {
            return new ResponseEntity<>(specialiteDao.findAll(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Specialite>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Specialite> getSpecialiteById(int id) {
        try {
            return new ResponseEntity<>(specialiteDao.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createSpecialite(Specialite specialite) {
        try {
            specialiteDao.save(specialite);
            return new ResponseEntity<>("Specialite Created Succesfully",HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateSpecialite(int id, Specialite specialite) {
        try {
            Specialite oldSpecialite = specialiteDao.findById(id);
            oldSpecialite.setNom(specialite.getNom());
            oldSpecialite.setRestaurantspecialite(specialite.getRestaurantspecialite());
            specialiteDao.save(oldSpecialite);
            return new ResponseEntity<>("Specialite Updated Succesfully",HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteSpecialite(int id) {
        try {
            specialiteDao.deleteById(id);
            return new ResponseEntity<>("Specialite Deleted Succesfully",HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
