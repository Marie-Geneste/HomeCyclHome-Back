package com.homecyclhome.service;

import com.homecyclhome.model.Product;
import com.homecyclhome.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser(); // Pour récupérer tous les utilisateurs
    // Méthode pour rechercher un utilisateur par email
    Optional<User> getUserByMail(String mail);
}
