package org.taeyoon.post.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.taeyoon.post.entity.Post;

import java.util.stream.IntStream;

@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    private SpringDataJpaPostRepository postRepository;

    @Test
    void insertDummies() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            Post post = Post.builder()
                    .title("Title...." + i)
                    .content("Content..." + i)
                    .author("Author" + (i%10))
                    .build();
            System.out.println(postRepository.save(post));
        });
    }
}
