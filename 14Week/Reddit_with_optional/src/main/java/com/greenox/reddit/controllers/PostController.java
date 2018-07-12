package com.greenox.reddit.controllers;

import com.greenox.reddit.models.Post;
import com.greenox.reddit.models.User;
import com.greenox.reddit.services.PostService;
import com.greenox.reddit.services.UserService;
import com.greenox.reddit.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postServ;
    private final UserService userServ;
    private final VoteService voteServ;

    @Autowired
    public PostController(PostService pService, UserService uService, VoteService vService) {
        this.postServ = pService;
        this.userServ = uService;
        this.voteServ = vService;
        //bizonyos posztokhoz rakjunk felhasználókat
        postServ.setUpDatabase(userServ.findAll());
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postServ.findAll();
    }

    @PostMapping("posts")
    public List<Post> addPost(@RequestBody Post postsToAdd, @RequestHeader("username") String username) {
        System.out.println(username);
        if ( username != null ) {
            if(userServ.findUserByName(username) != null ) { // find user in the database
                User user = userServ.findUserByName(username);
                postsToAdd.setOwner(user);
                postServ.saveNewPost(postsToAdd);
            } else {
                userServ.saveNewUser(username);
                postsToAdd.setOwner(userServ.findUserByName(username));
                postServ.saveNewPost(postsToAdd);
            }
        }
        return postServ.findAll();
        
    }

    @PutMapping("/posts/{id}/upvote")
    public List<Post> upvote(@PathVariable(name = "id") Long id) {
        postServ.increaseScore(postServ.getPostById(id));
        return postServ.findAll();
    }

    @PutMapping("/posts/{id}/downvote")
    public List<Post> downvote(@PathVariable(name = "id") Long id) {
        postServ.decreaseScore(postServ.getPostById(id));
        return postServ.findAll();
    }

    @DeleteMapping("/posts/{id}")
    public List<Post> delete(@PathVariable(name = "id") Long id) {
        postServ.deletePost(id);
        return postServ.findAll();
    }
}
