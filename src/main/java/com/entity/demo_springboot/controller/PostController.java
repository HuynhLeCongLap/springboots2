package com.entity.demo_springboot.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.demo_springboot.entity.Post;
import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.repository.UserRepository;
import com.entity.demo_springboot.service.PostService;
import com.entity.demo_springboot.service.UserService;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;
    
    // Liet ke all post
    @GetMapping
    public String listPost(Model model)
    {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "admin/posts";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model)
    {
        model.addAttribute("post", new Post());
        return "admin/post_form";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post, Principal principal)
    {
        if(principal == null)
        {
            return "redirect:/admin/logon";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        post.setUser(user);
        postService.createPost(post);
        return "redirect:/posts";
    }

    // Xem chi tiết
    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model)
    {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "admin/post_detail";
    }

    //Sửa bài viết
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "admin/post_edit";
    }

    //Lưu bài viết 
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post)
    {
        postService.updatePost(id, post);
        return "redirect:/posts";
    }

    // Xoá bài viết
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

}
