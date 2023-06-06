package com.app.Restaurant.service;

import com.app.Restaurant.POJO.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {
    ResponseEntity<List<Role>> getAllRoles();
    ResponseEntity<Role> getRoleById(int id);
    ResponseEntity<?> createRole(Role role);
    ResponseEntity<?> updateRole(int id, Role role);
    ResponseEntity<?> deleteRole(int id);

}
