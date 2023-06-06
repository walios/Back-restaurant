package com.app.Restaurant.users.service;



import com.app.Restaurant.users.Requests.UsersRequest;
import com.app.Restaurant.users.model.Users;

import java.util.List;

public interface UsersService {
    public List<Users> GetAllUsers();

    public Users AddUser(UsersRequest user);
}
