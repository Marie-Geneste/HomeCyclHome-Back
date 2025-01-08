package com.homecyclhome.security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        // Instancie le PasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Mot de passe à encoder
        String plainPassword = "azerty";

        // Encode le mot de passe
        String encodedPassword = passwordEncoder.encode(plainPassword);

        // Affiche le mot de passe encodé
        System.out.println("Mot de passe encodé : " + encodedPassword);
    }
}

