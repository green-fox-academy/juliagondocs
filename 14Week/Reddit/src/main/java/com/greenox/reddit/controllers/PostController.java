package com.greenox.reddit.controllers;

import com.greenox.reddit.models.Post;
import com.greenox.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/posts/{id}/upvote")
    public List<Post> upvote(@PathVariable(name="id") Long id) {
        service.increaseScore(service.getPostById(id));
        return service.findAll();
    }

    @PutMapping("/posts/{id}/downvote")
    public List<Post> downvote(@PathVariable(name="id") Long id) {
        service.decreaseScore(service.getPostById(id));
        return service.findAll();
    }

    @DeleteMapping("/posts/{id}")
    public List<Post> delete(@PathVariable(name="id") Long id) {
        service.deletePost(id);
        return service.findAll();
    }

    @PutMapping("/posts/{id}")
    public List<Post> updatePost(@RequestBody Post postToUpdate,
                                 @PathVariable Long id) {
            service.updatePost(postToUpdate, id);
        return service.findAll();
    }
}
