package com.greenfox.msql.controllers;
import com.greenfox.msql.model.Todo;
import com.greenfox.msql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class WebController {

    private final TodoRepository repo;

    @Autowired
    public WebController (TodoRepository repo) {
        this.repo=repo;
    }

    //@GetMapping(value={"/","/list"})
    //@GetMapping(value="/")
    //@ResponseBody
    //public String list() {
    //    return "This is my first todo";
    //}

    @GetMapping(value={"/","/list"})
    public String listOfTodo(Model model) {
        //repo.save(new Todo("title",false,false));
        model.addAttribute("todos", repo.findAll());
        return "todolist";
    }

    @GetMapping("/list2")
    public String listOfTodo(@ModelAttribute(value = "isActive") boolean bool, Model model) {
        List<Todo> activelist = new ArrayList<>();
        for (Todo todo : repo.findAll()) {
            if (todo.isDone() == bool) {
                activelist.add(todo);
            }
        }
        model.addAttribute("todos", activelist);
        return "todolist";
    }

    @GetMapping("/todo/add")
    public String addTodo(Model model) {
        model.addAttribute("newTodo", new Todo());
        return "add";
    }

    @PostMapping("/todo/add")
    public String addNewAccount(@ModelAttribute(value = "title") String title,
                                @ModelAttribute(value = "urgent") Boolean urgent,
                                @ModelAttribute(value = "done") Boolean done) {
        repo.save(new Todo(title,urgent,done));
        return "redirect:/todo/list";
    }

    @GetMapping(value ="/list/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        repo.deleteById(id);
        return new ModelAndView("redirect:/todo/list");
    }

    @GetMapping(value = "list/{id}/update")
    public String edit(@PathVariable long id,
                       Model model) {
        model.addAttribute("todo", repo.findById(id));
        return "edit";
    }


    @PostMapping(value = "/update")
    public ModelAndView update(@RequestParam("title") String title,
                               @RequestParam("id") Long id,
                               @RequestParam(value="done",required=false) boolean done,
                               @RequestParam(value ="urgent",required=false) boolean urgent) {
        Todo todo = repo.findById(id).get();
        todo.setTitle(title);
        if(done == true) {
            todo.setDone(done);
        } else {
            todo.setDone(false);
        }

        if (urgent == true) {
            todo.setUrgent(urgent);
        } else {
            todo.setUrgent(false);
        }
        repo.save(todo);
        return new ModelAndView("redirect:/todo/list");
    }
}

