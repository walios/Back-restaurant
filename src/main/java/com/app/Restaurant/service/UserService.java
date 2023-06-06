package com.app.Restaurant.service;

import com.app.Restaurant.POJO.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<User>> getAllUsers();
    ResponseEntity<User> getUserById(int id);
    ResponseEntity<?> createUser(User user);
    ResponseEntity<?> updateUser(int id, User user);
    ResponseEntity<?> deleteUser(int id);

}
