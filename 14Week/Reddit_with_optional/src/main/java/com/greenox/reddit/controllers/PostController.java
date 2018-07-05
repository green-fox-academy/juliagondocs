package com.greenox.reddit.controllers;

import com.greenox.reddit.models.Post;
import com.greenox.reddit.services.PostService;
import com.greenox.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postServ;
    private final UserService userServ;

    @Autowired
    public PostController( PostService pService, UserService uService) {
        this.postServ =pService;
        this.userServ=uService;
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postServ.findAll();
    }

    @PostMapping("posts")
    public List<Post> addPost(@RequestBody Post postsToAdd){
        postServ.saveNewPost(postsToAdd);
        return postServ.findAll();
    }

    @PutMapping("/posts/{id}/upvote")
    public List<Post> upvote(@PathVariable(name="id") Long id) {
        postServ.increaseScore(postServ.getPostById(id));
        return postServ.findAll();
    }

    @PutMapping("/posts/{id}/downvote")
    public List<Post> downvote(@PathVariable(name="id") Long id) {
        postServ.decreaseScore(postServ.getPostById(id));
        return postServ.findAll();
    }

    @DeleteMapping("/posts/{id}")
    public List<Post> delete(@PathVariable(name="id") Long id) {
        postServ.deletePost(id);
        return postServ.findAll();
    }
}
