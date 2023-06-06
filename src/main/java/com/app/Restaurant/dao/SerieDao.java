package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Role;
import com.app.Restaurant.POJO.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieDao extends JpaRepository<Serie,Integer> {
    Serie findByNom(String serie);
    Serie findById(int id);
}
