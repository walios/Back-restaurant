package com.app.Restaurant.POJO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import jakarta.persistence.Id;
import java.util.List;

@Data
@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy ="series")
    private List<Restaurant> rests;
}
