package com.entity.demo_springboot.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.service.FollowService;
import com.entity.demo_springboot.service.UserService;

@Controller
// @RequestMapping("/admin")
public class UserController {
    @RequestMapping("/logon")
    public String logon() {
        return "admin/logon";
    }
    @RequestMapping("/register")
    public String register()
    {
        return "admin/register";
    }
}
