package com.greenox.reddit.repositories;

import com.greenox.reddit.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {
    Post findPostById(Long id);
}
