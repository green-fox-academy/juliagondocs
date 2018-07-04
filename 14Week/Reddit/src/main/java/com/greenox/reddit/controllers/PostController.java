package com.greenox.reddit.controllers;

import com.greenox.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService service;

    @Autowired
    public PostController( PostService service) {
        this.service=service;
    }
}
