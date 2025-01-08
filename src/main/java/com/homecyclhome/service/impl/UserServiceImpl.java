package com.homecyclhome.service.impl;

import com.homecyclhome.dto.LoginRequest;
import com.homecyclhome.model.User;
import com.homecyclhome.repository.UserRepository;
import com.homecyclhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll(); // Utilisation de la méthode findAll() du repository
    }

    @Override
    public Optional<User> getUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }
}
