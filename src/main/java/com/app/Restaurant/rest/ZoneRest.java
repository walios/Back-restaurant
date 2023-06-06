package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.Zone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/zones")
public interface ZoneRest {
    @GetMapping(path ="/get")
    ResponseEntity<List<Zone>> getAllZones();

    @GetMapping(path ="/{id}")
    ResponseEntity<Zone> getZoneById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createZone(@RequestBody Zone zone);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateZone(@PathVariable int id, @RequestBody Zone zone);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteZone(@PathVariable int id);

}
