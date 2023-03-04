package org.taeyoon.post.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taeyoon.post.dto.PostDto;
import org.taeyoon.post.entity.Post;
import org.taeyoon.post.repository.SpringDataJpaPostRepository;

import javax.swing.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final SpringDataJpaPostRepository repository;

    @Override
    public Long register(PostDto postDto) {
        log.info("회원 등록 서비스 시작");
        Post post = dtoToEntity(postDto);
        repository.save(post);
        return post.getPostId();
    }
}
