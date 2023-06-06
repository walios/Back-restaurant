package com.app.Restaurant.rest;

import com.app.Restaurant.POJO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path ="/api/users")
public interface UserRest {
    @GetMapping(path ="/")
    ResponseEntity<List<User>> getAllUsers();

    @GetMapping(path ="/{id}")
    ResponseEntity<User> getUserById(@PathVariable int id);

    @PostMapping(path ="/save")
    ResponseEntity<?> createUser(@RequestBody User user);

    @PostMapping(path ="/update/{id}")
    ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user);

    @DeleteMapping(path ="/delete/{id}")
    ResponseEntity<?> deleteUser(@PathVariable int id);

}
