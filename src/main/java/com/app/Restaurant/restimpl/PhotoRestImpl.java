package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.rest.PhotoRest;
import com.app.Restaurant.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class PhotoRestImpl implements PhotoRest {

    @Autowired
    PhotoService photoService;
    @Override
    public ResponseEntity<List<Photo>> getAllPhotos() {
        try {
            return photoService.getAllPhotos();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Photo>>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Photo> getPhotoById(int id) {
        try {
            return photoService.getPhotoById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createPhoto(Photo photo) {
        try {
            return photoService.createPhoto(photo);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updatePhoto(int id, Photo photo) {
        try {
            return photoService.updatePhoto(id,photo);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deletePhoto(int id) {
        try {
            return photoService.deletePhoto(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
