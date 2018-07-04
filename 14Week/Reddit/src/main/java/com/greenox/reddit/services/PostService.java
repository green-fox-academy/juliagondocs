package com.greenox.reddit.services;

import com.greenox.reddit.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
}
