package com.greenfox.posts.domain;


import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    Post findOne(long id);
}
