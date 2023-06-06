package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.Specialite;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/specialites")
public interface SpecialiteRest {
    @GetMapping(path ="/")
    ResponseEntity<List<Specialite>> getAllSpecialites();

    @GetMapping(path ="/{id}")
    ResponseEntity<Specialite> getSpecialiteById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createSpecialite(@RequestBody Specialite specialite);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateSpecialite(@PathVariable int id, @RequestBody Specialite specialite);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteSpecialite(@PathVariable int id);

}
