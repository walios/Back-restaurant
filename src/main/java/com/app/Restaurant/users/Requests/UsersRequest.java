package com.app.Restaurant.users.Requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersRequest {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String roles;
    private float longitude;
    private float latitude;
}
