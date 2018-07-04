package com.greenox.reddit.controllers;

import com.greenox.reddit.models.Post;
import com.greenox.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private final PostService service;

    @Autowired
    public PostController( PostService service) {
        this.service=service;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return service.findAll();
    }

    @PostMapping("posts")
    public List<Post> addPost(@RequestBody Post postsToAdd){
        service.saveNewPost(postsToAdd);
        return service.findAll();
    }
}
