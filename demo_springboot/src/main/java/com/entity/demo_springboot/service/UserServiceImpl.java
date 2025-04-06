package com.entity.demo_springboot.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
// import com.entity.demo_springboot.controller.AdminController;
import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    // public void register(User user)
    // {
    //     if (userRepository.findByUsername(user.getUsername()) != null) 
    //     {
    //         throw new RuntimeException("Tên đăng nhập đã tồn tại !");
    //     }
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     userRepository.save(user);
    // }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user)
    {
        user.setRole("ADMIN");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
