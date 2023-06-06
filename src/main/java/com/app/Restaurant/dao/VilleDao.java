package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.User;
import com.app.Restaurant.POJO.Ville;
import com.app.Restaurant.POJO.Zone;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface VilleDao extends JpaRepository<Ville,Integer> {
    Ville findByNom(String ville);
    Ville findById(int id);
}
