package com.backend.zpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.zpi.entity.Users;
import com.backend.zpi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by their ID
    public Optional<Users> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    // Retrieve a user by email
    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Save a new user
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    // Update a user (assumes the user exists)
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
