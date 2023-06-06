package com.app.Restaurant.POJO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import java.util.List;

@NamedQuery(name="Ville.getAllVille", query = "select v from Ville v")
@NamedQuery(name="Ville.getAllZoneForVille", query = "select z from Zone z join z.ville v where v.nom = :ville")
@NamedQuery(name="Ville.getAllRestaurantsForZone", query = "select r from Restaurant r join r.zones z join z.ville v where v.nom = :ville and z.nom = :zoneName")


@Data
@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "ville")
    private List<Zone> zones;
}
