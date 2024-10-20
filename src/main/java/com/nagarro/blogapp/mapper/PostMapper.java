package com.nagarro.blogapp.mapper;

import com.nagarro.blogapp.dto.PostDTO;
import com.nagarro.blogapp.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDTO toPostDTO(Post post);

    Post toPost(PostDTO postDTO);

    List<PostDTO> toPostDTOList(List<Post> posts);

    List<Post> toPostList(List<PostDTO> postDTOs);
}
