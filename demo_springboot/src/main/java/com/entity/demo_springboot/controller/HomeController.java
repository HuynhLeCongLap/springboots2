package com.entity.demo_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @GetMapping
    public String admin()
    {
        return "redirect:/admin/";
    }
    @RequestMapping("/index")
    public String index()
    {
        return "admin/index";
    }
    @RequestMapping("/posts")
    public String post()
    {
        return "admin/posts";
    }
    @GetMapping("/user_list")
    public String userlist()
    {
        return "admin/user_list";
    }
    @GetMapping("/follow_list")
    public String followlist()
    {
        return "admin/follow_list";
    }
    @GetMapping("/post_form")
    public String post_form()
    {
        return "admin/post_form";
    }
    
}