package org.taeyoon.post.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.taeyoon.post.dto.PageRequestDto;
import org.taeyoon.post.dto.PageResultDto;
import org.taeyoon.post.dto.PostDto;
import org.taeyoon.post.entity.Post;
import org.taeyoon.post.repository.SpringDataJpaPostRepository;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class PostServiceTests {

    @Autowired PostService postService;

    @Test
    @DisplayName("회원 등록 테스트")
    void hihi() {

        PostDto postDto = PostDto.builder()
                .title("제목이다")
                .content("내용이다")
                .author("태윤이다")
                .build();

        Long regId = postService.register(postDto);

        log.info("resiter result = {}", regId);

    }


    @Test
    @DisplayName("PageRequestDto, PageResultDto 테스트")
    void testList() {
        PageRequestDto pageRequestDto = PageRequestDto.builder().page(1).size(10).build();

        PageResultDto<PostDto, Post> resultDto = postService.getList(pageRequestDto);

        for (PostDto postDto : resultDto.getDtoList()) {
            log.info("postDto = {}",postDto);
        }
    }

}