package com.entity.demo_springboot.service;

import java.util.List;

import com.entity.demo_springboot.entity.User;

public interface UserService {
    User findByUsername(String username);
    User saveUser(User user);
    User findById(Long id);
    List<User> findAllUsers();
    List<User> findAll();
    List<User> getAllUsers();

    
}
