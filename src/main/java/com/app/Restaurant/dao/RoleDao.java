package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.RestaurantSpecialite;
import com.app.Restaurant.POJO.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
    Role findById(int id);

}
