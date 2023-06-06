package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.Serie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/series")
public interface SerieRest {
    @GetMapping(path ="/")
    ResponseEntity<List<Serie>> getAllSeries();

    @GetMapping(path ="/{id}")
    ResponseEntity<Serie> getSerieById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createSerie(@RequestBody Serie serie);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateSerie(@PathVariable int id, @RequestBody Serie serie);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteSerie(@PathVariable int id);

}
