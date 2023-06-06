package com.app.Restaurant.restimpl;

import com.app.Restaurant.POJO.Role;
import com.app.Restaurant.rest.RoleRest;
import com.app.Restaurant.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleRestImpl implements RoleRest {
    @Autowired
    RoleService roleService;
    @Override
    public ResponseEntity<List<Role>> getAllRoles() {
        try {
            return roleService.getAllRoles();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<Role>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Role> getRoleById(int id) {
        try {
            return roleService.getRoleById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> createRole(Role role) {
        try {
            return roleService.createRole(role);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateRole(int id, Role role) {
        try {
            return roleService.updateRole(id,role);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteRole(int id) {
        try {
            return roleService.deleteRole(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<Role>(new Role(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
