package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.User;
import com.app.Restaurant.rest.UserRest;
import com.app.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return userService.getAllUsers();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<User>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<User> getUserById(int id) {
        try {
            return userService.getUserById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createUser(User user) {
        try {
            return userService.createUser(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateUser(int id, User user) {
        try {
            return userService.updateUser(id,user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteUser(int id) {
        try {
            return userService.deleteUser(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
