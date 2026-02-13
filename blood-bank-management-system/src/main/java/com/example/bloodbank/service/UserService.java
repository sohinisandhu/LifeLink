package com.example.bloodbank.service;

import com.example.bloodbank.model.User;
import com.example.bloodbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // public Optional<User> findByUsername(String username) {
    //     return Optional.ofNullable(userRepository.findByUsername(username));
    // }
    public Optional<User> findByUsername(String username) {
    // Simply return the Optional that the repository gives you
    return userRepository.findByUsername(username);
}

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}