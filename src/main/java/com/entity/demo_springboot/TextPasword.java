package com.entity.demo_springboot;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TextPasword {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
