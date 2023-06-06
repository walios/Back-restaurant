package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Restaurant;
import com.app.Restaurant.POJO.Serie;
import com.app.Restaurant.POJO.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteDao extends JpaRepository<Specialite,Integer> {
    Specialite findById(int id);
}
