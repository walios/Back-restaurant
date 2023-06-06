package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Serie;
import com.app.Restaurant.rest.SerieRest;
import com.app.Restaurant.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SerieRestImpl implements SerieRest {
    @Autowired
    private SerieService serieService;
    @Override
    public ResponseEntity<List<Serie>> getAllSeries() {
        try {
            return serieService.getAllSeries();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Serie>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Serie> getSerieById(int id) {
        try {
            return serieService.getSerieById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createSerie(Serie serie) {
        try {
            return serieService.createSerie(serie);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateSerie(int id, Serie serie) {
        try {
            return serieService.updateSerie(id, serie);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteSerie(int id) {
        try {
            return serieService.deleteSerie(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
