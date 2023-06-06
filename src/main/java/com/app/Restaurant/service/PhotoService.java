package com.app.Restaurant.service;

import com.app.Restaurant.POJO.Photo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PhotoService {
    ResponseEntity<List<Photo>>  getAllPhotos();
    ResponseEntity<Photo> getPhotoById(int id);
    ResponseEntity<?> createPhoto(Photo photo);
    ResponseEntity<?> updatePhoto(int id, Photo photo);
    ResponseEntity<?> deletePhoto(int id);

}
