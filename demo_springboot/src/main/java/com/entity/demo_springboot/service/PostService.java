package com.entity.demo_springboot.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.demo_springboot.entity.Post;
import com.entity.demo_springboot.entity.User;
import com.entity.demo_springboot.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    // Lấy All Post
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUser(user);
    }

    // Post a ID
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy bài viết"));
    }

    // Theo status
    public Post savePost(Post post) {
        if(post.getStatus() != null || post.getStatus().isEmpty())
        {
            post.setStatus("DRAFT");
        }
        return postRepository.save(post);
    }

    // Update Post
    public void updatePost(Long id, Post upPost)
    {
        Post existingPost = getPostById(id);
        existingPost.setTitle(upPost.getTitle());
        existingPost.setTitle(upPost.getContent());
        existingPost.setStatus(upPost.getStatus());
        postRepository.save(existingPost);
    }

    // Thêm vào viết
    public void createPost(Post post)
    {
        postRepository.save(post);
    }
    
    // Remove Post
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
