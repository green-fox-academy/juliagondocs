package com.greenox.reddit.services;

import com.greenox.reddit.models.Post;
import com.greenox.reddit.models.User;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    void saveNewPost(Post post);
    Post getPostById(Long id);

    void increaseScore(Post post);
    void decreaseScore(Post post);

    void deletePost(Long id);

    void setUpDatabase(List<User> all);
}
