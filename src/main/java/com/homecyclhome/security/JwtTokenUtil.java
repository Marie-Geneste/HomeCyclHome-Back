package com.homecyclhome.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "KLJDQLJQLIQSmlkdqsdqmslklqslkdksqkjkjsqdjqk";

    // Durée de validité du token en millisecondes (ici 1 heure)
    private static final long EXPIRATION_TIME = 3600000;

    // Méthode pour générer un JWT
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)  // Mettre l'email de l'utilisateur dans le sujet
                .setIssuedAt(new Date())  // Date de création du token
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Date d'expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // Signature du token avec la clé secrète
                .compact();
    }

    // Méthode pour valider un JWT
    public boolean validateToken(String token, String email) {
        String tokenEmail = extractUsername(token);
        return (tokenEmail.equals(email) && !isTokenExpired(token));
    }

    // Extraire l'email (ou nom d'utilisateur) du token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Vérifier si le token est expiré
    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}

