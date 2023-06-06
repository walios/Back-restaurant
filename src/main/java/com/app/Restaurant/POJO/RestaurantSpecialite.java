package com.app.Restaurant.POJO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.Id;

@Data
@Entity
@IdClass(RestaurantSpecialiteId.class)
public class RestaurantSpecialite {


        @Id
        @ManyToOne
        @JoinColumn(name = "restaurant_id")
        @JsonIgnore
        private Restaurant restaurant;


        @Id
        @ManyToOne
        @JoinColumn(name = "specialite_id")
        private Specialite specialite;
}
