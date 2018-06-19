package com.greenfox.posts.controllers;

import com.greenfox.posts.domain.Post;
import com.greenfox.posts.domain.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping(value="")
    public String listPosts(Model model) {
        model.addAttribute("posts", repository.findAll());
        return "posts/list";
    }

    @GetMapping(value = "/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/posts");
    }

    @GetMapping(value="/new")
    public String newProject() {
        return "posts/new";
    }

    @PostMapping(value = "/create")
    public ModelAndView create(@RequestParam("message") String comment) {
        repository.save(new Post(comment));
        return new ModelAndView("redirect:/posts");
    }

    @PostMapping(value = "/update")
    public ModelAndView update(@RequestParam("post_id") long id,
                               @RequestParam("message") String message) {
        Post post = repository.findOne(id);
        post.setMessage(message);
        repository.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable long id,
                       Model model) {
        Post post = repository.findOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }


}
