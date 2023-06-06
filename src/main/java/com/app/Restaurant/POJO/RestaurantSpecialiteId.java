package com.app.Restaurant.POJO;



import lombok.Data;

import java.io.Serializable;

public class RestaurantSpecialiteId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Restaurant restaurant;
    private Specialite specialite;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}