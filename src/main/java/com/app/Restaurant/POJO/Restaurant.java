package com.app.Restaurant.POJO;

import com.app.Restaurant.users.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String Lattitude;
    private String Longtitude;
    private LocalTime open;

    private LocalTime close;
    private String adresse;
    private String weekend;
    private int rank;
    private String picture;

    private String description;
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantSpecialite> restaurantspecialite;


    @OneToOne
    private Users user;


    @ManyToOne
    private Zone zones;

    @ManyToOne
    private Serie series;

    @OneToOne(mappedBy="rest")
    private Photo photos;
}
