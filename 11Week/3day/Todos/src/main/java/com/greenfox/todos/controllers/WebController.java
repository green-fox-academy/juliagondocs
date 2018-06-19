package com.greenfox.todos.controllers;

import com.greenfox.todos.model.Todo;
import com.greenfox.todos.repositories.ToDoRepository;
import com.greenfox.todos.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    private final ToDoRepository repo;
    private final ToDoService service;

    @Autowired
    public WebController (ToDoRepository repo, ToDoService service) {
        this.repo=repo;
        this.service=service;
    }

    //@GetMapping(value={"/","/list"})
    @GetMapping(value="/")
    @ResponseBody
    public String list() {
        return "This is my first todo";
    }

    @GetMapping("list")
    public String listOfTodo(Model model) {
        repo.save(new Todo("title",false,false));
        model.addAttribute("todos", repo.findAll());
        return "todolist";
    }
}
