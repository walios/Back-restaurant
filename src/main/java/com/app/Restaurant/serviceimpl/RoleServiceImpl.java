package com.app.Restaurant.serviceimpl;

import com.app.Restaurant.POJO.Role;
import com.app.Restaurant.dao.RoleDao;
import com.app.Restaurant.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            return new ResponseEntity<>(roleDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Role>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public ResponseEntity<Role> getRoleById(int id) {
        try {
            return new ResponseEntity<>(roleDao.findById(id), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createRole(Role role) {
        try {
            roleDao.save(role);
            return new ResponseEntity<>("Role Created Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateRole(int id, Role role) {
        try {
            Role oldRole = roleDao.findById(id);
            oldRole.setUser(role.getUser());
            oldRole.setLibelle(role.getLibelle());
            roleDao.save(oldRole);
            return new ResponseEntity<>("Role Updated Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteRole(int id) {
        try {
            roleDao.deleteById(id);
            return new ResponseEntity<>("Role Deleted Succesfully",HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
