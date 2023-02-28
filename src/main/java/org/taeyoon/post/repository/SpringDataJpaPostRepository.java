package org.taeyoon.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.taeyoon.post.entity.Post;

public interface SpringDataJpaPostRepository extends JpaRepository<Post, Long>, QuerydslPredicateExecutor<Post> {
}
