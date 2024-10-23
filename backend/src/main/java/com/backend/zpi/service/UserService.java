package com.backend.zpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.zpi.entity.User;
import com.backend.zpi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by their ID
    public Optional<User> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    // Retrieve a user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Save a new user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Update a user (assumes the user exists)
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
