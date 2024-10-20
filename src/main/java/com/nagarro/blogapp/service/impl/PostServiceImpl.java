package com.nagarro.blogapp.service.impl;

import com.nagarro.blogapp.dto.PostDTO;
import com.nagarro.blogapp.entity.Post;
import com.nagarro.blogapp.mapper.PostMapper;
import com.nagarro.blogapp.repository.PostRepository;
import com.nagarro.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired

    private PostMapper postMapper;

    public List<PostDTO> getAllPosts() {
        List<Post> postList = postRepository.findAll();

        return postMapper.toPostDTOList(postList);
    }

    public PostDTO getPostById(Long id) {
        final Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            new RuntimeException("Post not found with id: " + id);
        }
        return postMapper.toPostDTO(post.get());
    }


    public PostDTO createPost(PostDTO postDTO) {
        final Post post = postMapper.toPost(postDTO);
        final Post savedPost = postRepository.save(post);
        return postMapper.toPostDTO(savedPost);
    }

    public PostDTO updatePost(Long id, PostDTO postDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        final Post updatedPost = postRepository.save(post);
        return postMapper.toPostDTO(updatedPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
