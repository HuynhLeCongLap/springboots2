package com.entity.demo_springboot.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.demo_springboot.entity.Follow;
import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.service.FollowService;
import com.entity.demo_springboot.service.UserService;

@Controller
@RequestMapping("/follows")
public class FollowController {
    // @Autowired
    // private FollowService followService;

    // @Autowired
    // private UserService userService;

    // @PostMapping("/follow/{id}")
    // public String followUser(@PathVariable Long id, @RequestParam(required = false) Long currentUserId) {
    //     followService.followUser(currentUserId, id);
    //     return "redirect:/admin/user_list";
    // }

    // @DeleteMapping("/unfollow/{id}")
    // public String unfollowUser(@PathVariable Long id, @RequestParam(required = false) Long currentUserId) {
    //     followService.unfollowUser(currentUserId, id);
    //     return "redirect:/admin/user_list";
    // }

    // @GetMapping("/followers/{userId}")
    // public String getFollowers(@PathVariable Long userId, Model model) {
    //     List<Follow> followers = followService.getFollowers(userId);
    //     model.addAttribute("followers", followers);
    //     return "admin/follow_list";
    // }

    // //Lấy danh sách những người theo dõi
    // @GetMapping("/followers")
    // public String getFollowers(Model model, Principal principal) {
    //     String currentUsername = principal.getName();
    //     User currentUser = userService.findByUsername(currentUsername);
    //     List<Follow> followList = followService.getFollowers(currentUser.getId());
    //     List<User> followers = followList.stream()
    //                                      .map(Follow::getFollowedUser)
    //                                      .collect(Collectors.toList());
    //     model.addAttribute("followers", followers);
    //     return "admin/follow_list";
    // }

    // // Theo dõi người dùng
    // @PostMapping("/follow/{id}")
    // public String followUser(@PathVariable Long id, Principal principal) {
    //     String currentUsername = principal.getName();
    //     User currentUser = userService.findByUsername(currentUsername);
    //     followService.followUser(currentUser.getId(), id);
    //     return "redirect:/admin/user_list";
    // }

    // // Bỏ theo dõi người dùng
    // @PostMapping("/unfollow/{id}")
    // public String unfollowUser(@PathVariable Long id, Principal principal) {
    //     String currentUsername = principal.getName();
    //     User currentUser = userService.findByUsername(currentUsername);
    //     followService.unfollowUser(currentUser.getId(), id);
    //     return "redirect:/admin/user_list";
    // }

    private final UserService userService;
    private final FollowService followService;
    @Autowired
    public FollowController(UserService userService, FollowService followService) {
        this.userService = userService;
        this.followService = followService;
    }

    @GetMapping("/users")
    public String showFollowList(Model model, Principal principal) {
        String username = principal.getName();
        User currentUser = userService.findByUsername(username);
        
        List<User> followers = followService.getFollowers(currentUser);
        List<User> following = followService.getFollowing(currentUser);
        
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("followers", followers);
        model.addAttribute("following", following);
        
        return "admin/follow_list";
    }

    @PostMapping("/follow/{userId}")
    public String followUser(@PathVariable Long userId, Authentication authentication, RedirectAttributes redirectAttributes) {
        try {
            String username = authentication.getName();
            User currentUser = userService.findByUsername(username);
            User userToFollow = userService.findById(userId);
            
            if (currentUser.getId().equals(userId)) {
                redirectAttributes.addFlashAttribute("errorMessage", "Bạn không thể theo dõi chính mình");
                return "redirect:/users/list";
            }
            
            followService.followUser(currentUser, userToFollow);
            redirectAttributes.addFlashAttribute("successMessage", "Đã theo dõi người dùng thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
        }
        
        return "redirect:/users/list";
    }
    @PostMapping("/unfollow/{userId}")
    public String unfollowUser(@PathVariable Long userId, Authentication authentication, RedirectAttributes redirectAttributes) {
        try {
            String username = authentication.getName();
            User currentUser = userService.findByUsername(username);
            User userToUnfollow = userService.findById(userId);
            
            followService.unfollowUser(currentUser, userToUnfollow);
            redirectAttributes.addFlashAttribute("successMessage", "Đã bỏ theo dõi người dùng thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
        }
        
        return "redirect:/users/list";
    }
}