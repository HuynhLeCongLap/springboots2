package com.entity.demo_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.demo_springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
