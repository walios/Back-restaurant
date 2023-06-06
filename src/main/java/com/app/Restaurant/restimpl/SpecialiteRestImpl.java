package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Specialite;
import com.app.Restaurant.rest.SpecialiteRest;
import com.app.Restaurant.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SpecialiteRestImpl implements SpecialiteRest {
    @Autowired
    SpecialiteService specialiteService;
    @Override
    public ResponseEntity<List<Specialite>> getAllSpecialites() {
        try {
            return specialiteService.getAllSpecialites();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Specialite>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Specialite> getSpecialiteById(int id) {
        try {
            return specialiteService.getSpecialiteById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createSpecialite(Specialite specialite) {
        try {
            return specialiteService.createSpecialite(specialite);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateSpecialite(int id, Specialite specialite) {
        try {
            return specialiteService.updateSpecialite(id,specialite);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteSpecialite(int id) {
        try {
            return specialiteService.deleteSpecialite(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Specialite>(new Specialite(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
