package org.taeyoon.post.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.taeyoon.post.dto.PostDto;
import org.taeyoon.post.repository.SpringDataJpaPostRepository;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class PostServiceTests {

    @Autowired PostService postService;

    @Test
    void hihi() {

        PostDto postDto = PostDto.builder()
                .title("제목이다")
                .content("내용이다")
                .author("태윤이다")
                .build();

        Long regId = postService.register(postDto);

        log.info("resiter result = {}", regId);


    }

}