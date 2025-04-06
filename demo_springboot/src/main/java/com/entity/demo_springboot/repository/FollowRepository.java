package com.entity.demo_springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.demo_springboot.entity.Follow;
import com.entity.demo_springboot.entity.User;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    // boolean existsByFollowingUserAndFollowedUser(User followingUser, User followedUser);
    // void deleteByFollowingUserAndFollowedUser(User followingUser, User followedUser);

    // @Query("SELECT f.followingUser FROM Follow f WHERE f.followedUser.id = :userId")
    // List<Follow> findByFollowedUser(User followedUser);
    // @Query("SELECT f.followedUser FROM Follow f WHERE f.followingUser.id = :userId")
    // List<Follow> findByFollowingUser(User followingUser);

    Optional<Follow> findByFollowingUserAndFollowedUser(User followingUser, User followedUser);
    
    List<Follow> findByFollowedUser(User followedUser);
    
    List<Follow> findByFollowingUser(User followingUser);
    
    long countByFollowedUser(User followedUser);
    
    long countByFollowingUser(User followingUser);
}
