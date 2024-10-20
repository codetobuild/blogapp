package com.nagarro.blogapp.service;

import com.nagarro.blogapp.dto.PostDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<PostDTO> getAllPosts();
    public PostDTO getPostById(Long id);
    public PostDTO createPost(PostDTO post);
    public PostDTO updatePost(Long id, PostDTO postDetails);
    public void deletePost(Long id);
}
