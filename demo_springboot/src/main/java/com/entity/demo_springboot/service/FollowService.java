package com.entity.demo_springboot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import com.entity.demo_springboot.controller.AdminController;
import com.entity.demo_springboot.entity.Follow;
import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.repository.FollowRepository;
import com.entity.demo_springboot.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class FollowService {
    // @Autowired
    // private FollowRepository followRepository;

    // @Autowired
    // private UserRepository userRepository;

    // @Transactional
    // public void followUser(Long followingUserId, Long followedUserId) {
    //     User followingUser = userRepository.findById(followingUserId).orElseThrow(() -> new RuntimeException("User not found"));
    //     User followedUser = userRepository.findById(followedUserId).orElseThrow(() -> new RuntimeException("User not found"));
        
    //     if (!followRepository.existsByFollowingUserAndFollowedUser(followingUser, followedUser)) {
    //         Follow follow = new Follow();
    //         follow.setFollowingUser(followingUser);
    //         follow.setFollowedUser(followedUser);
    //         followRepository.save(follow);
    //     }
    // }

    // @Transactional
    // public void unfollowUser(Long followingUserId, Long followedUserId) {
    //     User followingUser = userRepository.findById(followingUserId).orElseThrow(() -> new RuntimeException("User not found"));
    //     User followedUser = userRepository.findById(followedUserId).orElseThrow(() -> new RuntimeException("User not found"));
        
    //     followRepository.deleteByFollowingUserAndFollowedUser(followingUser, followedUser);
    // }

    // public List<Follow> getFollowers(Long userId) {
    //     User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    //     return followRepository.findByFollowedUser(user);
    // }

    // public List<Follow> getFollowing(Long userId) {
    //     User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    //     return followRepository.findByFollowingUser(user);
    // }

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowService(FollowRepository followRepository, UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void followUser(User followingUser, User followedUser )
    {
        if(followRepository.findByFollowingUserAndFollowedUser(followingUser, followedUser).isPresent())
        {
            throw new RuntimeException("Bạn đã theo dõi người dùng này rồi");
        }
        if(followedUser.getId().equals(followedUser.getId()))
        {throw new RuntimeException("Bạn không thể theo dõi chính mình");}

        Follow follow = new Follow();
        follow.setFollowingUser(followingUser);
        follow.setFollowedUser(followedUser);
        follow.setCreatedAt(LocalDateTime.now());

        followRepository.save(follow);
    }

    @Transactional
    public void unfollowUser(User followingUser, User followedUser) {
        Follow follow = followRepository.findByFollowingUserAndFollowedUser(followingUser, followedUser)
            .orElseThrow(() -> new RuntimeException("Bạn chưa theo dõi người dùng này"));
            
        followRepository.delete(follow);
    }

    public List<User> getFollowers(User user) {
        List<Follow> followers = followRepository.findByFollowedUser(user);
        return followers.stream()
            .map(Follow::getFollowingUser)
            .collect(Collectors.toList());
    }
    
    public List<User> getFollowing(User user) {
        List<Follow> following = followRepository.findByFollowingUser(user);
        return following.stream()
            .map(Follow::getFollowedUser)
            .collect(Collectors.toList());
    }
    
    public boolean isFollowing(User followingUser, User followedUser) {
        return followRepository.findByFollowingUserAndFollowedUser(followingUser, followedUser).isPresent();
    }
}