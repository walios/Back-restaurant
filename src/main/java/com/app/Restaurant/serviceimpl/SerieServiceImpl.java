package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Serie;
import com.app.Restaurant.dao.SerieDao;
import com.app.Restaurant.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {
    @Autowired
    private SerieDao serieDao;
    @Override
    public ResponseEntity<List<Serie>> getAllSeries() {
        try {
            return new ResponseEntity<>(serieDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Serie>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Serie> getSerieById(int id) {
        try {
            return new ResponseEntity<>(serieDao.findById(id), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createSerie(Serie serie) {
        try {
            serieDao.save(serie);
            return new ResponseEntity<>("Serie Created Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateSerie(int id, Serie serie) {
        try {
            Serie oldSerie = serieDao.findById(id);
            oldSerie.setNom(serie.getNom());
            oldSerie.setRests(serie.getRests());
            serieDao.save(oldSerie);
            return new ResponseEntity<>("Serie Updated Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteSerie(int id) {
        try {
            serieDao.deleteById(id);
            return new ResponseEntity<>("Serie Deleted Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Serie>(new Serie(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
