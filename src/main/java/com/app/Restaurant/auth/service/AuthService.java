package com.app.Restaurant.auth.service;



import com.app.Restaurant.users.Requests.UsersRequest;
import com.app.Restaurant.users.model.Users;

import java.util.Optional;

public interface AuthService {
    public Optional<Users> AddUser(UsersRequest user);
}
