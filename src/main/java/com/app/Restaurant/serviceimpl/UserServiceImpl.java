package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.User;
import com.app.Restaurant.dao.SpecialiteDao;
import com.app.Restaurant.dao.UserDao;
import com.app.Restaurant.service.SpecialiteService;
import com.app.Restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<User>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<User> getUserById(int id) {
        try {
            return new ResponseEntity<>(userDao.findById(id), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createUser(User user) {
        try {
            userDao.save(user);
            return new ResponseEntity<>("User Created Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateUser(int id, User user) {
        try {
            User oldUser = userDao.findById(id);
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setStatus(user.getStatus());
            oldUser.setPassword(user.getPassword());
            oldUser.setContactNumber(user.getContactNumber());
            oldUser.setRoles(user.getRoles());
            oldUser.setRest(user.getRest());
            userDao.save(oldUser);
            return new ResponseEntity<>("User Updated Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteUser(int id) {
        try {
            userDao.deleteById(id);
            return new ResponseEntity<>("User Deleted Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<User>(new User(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
