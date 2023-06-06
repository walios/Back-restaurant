package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/photos")
public interface PhotoRest {

    @GetMapping(path ="/")
    ResponseEntity<List<Photo>> getAllPhotos();

    @GetMapping(path ="/{id}")
    ResponseEntity<Photo> getPhotoById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createPhoto(@RequestBody Photo photo);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updatePhoto(@PathVariable int id, @RequestBody Photo photo);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deletePhoto(@PathVariable int id);
}