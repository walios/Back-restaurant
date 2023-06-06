package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/roles")
public interface RoleRest {
    @GetMapping(path ="/")
    ResponseEntity<List<Role>> getAllRoles();

    @GetMapping(path ="/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createRole(@RequestBody Role role);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateRole(@PathVariable int id, @RequestBody Role role);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteRole(@PathVariable int id);

}
