package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.dao.PhotoDao;
import com.app.Restaurant.service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoDao photoDao;
    @Override
    public ResponseEntity<List<Photo>> getAllPhotos() {
        try {
            return new ResponseEntity<>(photoDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Photo>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Photo> getPhotoById(int id) {
        try {
            return new ResponseEntity<>(photoDao.findById(id), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createPhoto(Photo photo) {
        try {
            photoDao.save(photo);
            return new ResponseEntity<>("Photo Created Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updatePhoto(int id, Photo photo) {
        try {
            Photo oldPhoto = photoDao.findById(id);
            oldPhoto.setUrl(photo.getUrl());
            oldPhoto.setRest(photo.getRest());
            photoDao.save(oldPhoto);
            return new ResponseEntity<>("Photo Updated Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deletePhoto(int id) {
        try {
            photoDao.deleteById(id);
            return new ResponseEntity<>("Photo Deleted Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Photo>(new Photo(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
