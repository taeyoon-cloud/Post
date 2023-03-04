package org.taeyoon.post.service;

import org.taeyoon.post.dto.PostDto;
import org.taeyoon.post.entity.Post;

public interface PostService {

    Long register(PostDto postDto);

    // default를 통해 구현 클래스에서 동작할 수 있는 메소드
    default Post dtoToEntity(PostDto postDto) {
        Post entity = Post.builder()
                .postId(postDto.getPostId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .author(postDto.getAuthor())
                .build();

        return entity;
    }
}
