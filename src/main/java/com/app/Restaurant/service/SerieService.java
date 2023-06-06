package com.app.Restaurant.service;

import com.app.Restaurant.POJO.Serie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SerieService {
    ResponseEntity<List<Serie>> getAllSeries();
    ResponseEntity<Serie> getSerieById(int id);
    ResponseEntity<?> createSerie(Serie serie);
    ResponseEntity<?> updateSerie(int id, Serie serie);
    ResponseEntity<?> deleteSerie(int id);

}
