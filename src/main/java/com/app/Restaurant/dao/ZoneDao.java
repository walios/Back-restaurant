package com.app.Restaurant.dao;

import com.app.Restaurant.POJO.Ville;
import com.app.Restaurant.POJO.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ZoneDao extends JpaRepository<Zone,Integer> {
    Optional<Zone> findByNomAndVille_Nom(String nomZone, String nomVille);
    Zone findByNomAndVilleNom(String zone, String ville);
    Zone findById(int id);
}
