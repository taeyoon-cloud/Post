package org.taeyoon.post.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.taeyoon.post.entity.Post;
import org.taeyoon.post.entity.QPost;

import java.util.Optional;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
public class PostRepositoryTests {

    @Autowired
    private SpringDataJpaPostRepository postRepository;

    @Test
    void insertDummies() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Post post = Post.builder()
                    .title("Title...." + i)
                    .content("Content..." + i)
                    .author("Author" + (i%10))
                    .build();
            System.out.println(postRepository.save(post));
        });
    }

    @Test
    void updateTest() {
        Optional<Post> result = postRepository.findById(5L);

        if (result.isPresent()) {
            Post findPost = result.get();
            findPost.changeTitle("제목 바뀜!");

            postRepository.save(findPost);
        }
    }

    // Querydsl 테스트
    @Test
    void testQuery1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("postId").descending());

        QPost post = QPost.post;

        String keyword = "1"; // title에 1이 들어가는 경우를 찾는다.
        BooleanBuilder builder = new BooleanBuilder();

        BooleanExpression expression = post.title.contains(keyword);

        builder.and(expression);

        Page<Post> result = postRepository.findAll(builder, pageable);

        result.stream().forEach(post1 -> {
            log.info("posts = {}", post1);
        });


    }

    // 다중 항목 검색 테스트
    @Test
    void testQuery2() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("postId").ascending());

        QPost post = QPost.post;

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();

        // 제목 혹은 내용 혹은 저자가 keyword를 포함하고 있고, postId가 2보다 큰 경우
        BooleanExpression exContent = post.content.contains(keyword);
        BooleanExpression exTitle = post.title.contains(keyword);
        BooleanExpression exAuthor = post.author.contains(keyword);

        BooleanExpression exAll = exContent.or(exTitle).or(exAuthor);

        builder.and(exAll);
        builder.and(post.postId.gt(2L));

        Page<Post> result = postRepository.findAll(builder, pageable);

        result.stream().forEach(post1 -> {
            log.info("post = {}",post1);
        });
    }
}
