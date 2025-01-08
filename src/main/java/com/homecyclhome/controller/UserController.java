package com.homecyclhome.controller;

import com.homecyclhome.dto.LoginRequest;
import com.homecyclhome.dto.LoginResponse;
import com.homecyclhome.model.Business;
import com.homecyclhome.model.User;
import com.homecyclhome.service.AuthService;
import com.homecyclhome.service.BusinessService;
import com.homecyclhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;


    //GetAll User
    @GetMapping
    public @ResponseBody List<User> getAllUser(){
        return userService.getAllUser();
    }

    //login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Appeler le service AuthService pour l'authentification et récupérer le token
            String jwtToken = authService.login(loginRequest);
            LoginResponse tokenResponse = new LoginResponse(jwtToken); // Créer un DTO avec le token
            return ResponseEntity.ok(tokenResponse); // Retourner la réponse avec le token
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());  // Retourner l'erreur en cas d'échec
        }
    }
}
