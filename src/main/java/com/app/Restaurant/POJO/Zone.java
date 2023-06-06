package com.app.Restaurant.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @ManyToOne
    private Ville ville;

    @JsonIgnore
    @OneToMany(mappedBy="zones")
    private List<Restaurant> rests;

}
