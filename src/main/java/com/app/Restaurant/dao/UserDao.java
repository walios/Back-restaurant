package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Specialite;
import com.app.Restaurant.POJO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao  extends JpaRepository<User,Integer> {
    User findById(int id);
}
