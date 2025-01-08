package com.homecyclhome.service;

import com.homecyclhome.dto.LoginRequest;
import com.homecyclhome.model.User;
import com.homecyclhome.repository.UserRepository;
import com.homecyclhome.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String login(LoginRequest loginRequest) {
        // Rechercher l'utilisateur par email
        User user = userRepository.findByMail(loginRequest.getMail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Vérifier le mot de passe
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Générer le token JWT
        return jwtTokenUtil.generateToken(user.getMail());
    }
}
