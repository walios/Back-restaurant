package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Photo;
import com.app.Restaurant.POJO.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDao extends JpaRepository<Photo,Integer> {
    Photo findById(int id);
}
