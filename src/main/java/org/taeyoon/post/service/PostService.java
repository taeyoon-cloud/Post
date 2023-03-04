package org.taeyoon.post.service;

import org.taeyoon.post.dto.PageRequestDto;
import org.taeyoon.post.dto.PageResultDto;
import org.taeyoon.post.dto.PostDto;
import org.taeyoon.post.entity.Post;

public interface PostService {

    Long register(PostDto postDto);

    PageResultDto<PostDto, Post> getList(PageRequestDto requestDto);

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

    default PostDto entityToDto(Post post) {
        PostDto postDto = PostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .build();

        return postDto;
    }
}
