package com.app.Restaurant.auth.controller;

import com.app.Restaurant.auth.request.AuthenticationRequest;
import com.app.Restaurant.auth.service.AuthService;
import com.app.Restaurant.config.JwtUtils;
import com.app.Restaurant.userSecurity.dao.JpaUserDetailsService;

import com.app.Restaurant.userSecurity.model.UserSecurity;
import com.app.Restaurant.users.Requests.UsersRequest;
import com.app.Restaurant.users.model.Users;
import com.app.Restaurant.users.repository.UsersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JpaUserDetailsService jpaUserDetailsService;

    private final AuthService authService;
    private final UsersRepository usersRepository;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword(),
                            new ArrayList<>()));
            final UserDetails user = jpaUserDetailsService.loadUserByUsername(request.getEmail());
            if (user != null) {
                String jwt = jwtUtils.generateToken(user);
                Cookie cookie = new Cookie("jwt", jwt);
                cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                cookie.setPath("/"); // Global
                response.addCookie(cookie);
                return ResponseEntity.ok(jwt);
            }
            return ResponseEntity.status(400).body("Error authenticating");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body("" + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserSecurity> register(@RequestBody UsersRequest user) throws Exception {
        return ResponseEntity.ok(authService.AddUser(user).map(UserSecurity::new).orElseThrow(() -> new Exception("Unknown")));
    }
    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> getUserFromBody(@RequestBody Map<String, String> requestBody) {
        try {
            String jwt = requestBody.get("jwt");
            if (jwt == null) {
                return ResponseEntity.status(400).body(null);
            }
            String email = jwtUtils.extractUsername(jwt);
            final Users user = usersRepository.findByEmail(email).orElseThrow(() -> new Exception("User not found"));

            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("id", user.getId());
            userDetails.put("first_name", user.getFirst_name());
            userDetails.put("last_name", user.getLast_name());
            userDetails.put("email", user.getEmail());
            userDetails.put("latitude", user.getLatitude());
            userDetails.put("longitude", user.getLongitude());
            userDetails.put("roles", user.getRoles());

            return ResponseEntity.ok(userDetails);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(400).body(null);
        }
    }
}
