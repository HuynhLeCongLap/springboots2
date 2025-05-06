package com.entity.demo_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
