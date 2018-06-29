package com.greenfox.msql.controllers;

import com.greenfox.msql.model.Assignee;
import com.greenfox.msql.model.Todo;
import com.greenfox.msql.services.AssigneeService;
import com.greenfox.msql.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    private final ToDoService servTodo;
    private final AssigneeService servAssign;
    private boolean searchIsActive = false;

    @Autowired
    public WebController(ToDoService servTodo, AssigneeService servAssign) {
        this.servTodo = servTodo;
        this.servAssign=servAssign;
    }


    @GetMapping(value = {"/", "/list"})
    public String listOfTodo(Model model) {
        if (!searchIsActive) {
            model.addAttribute("todos", servTodo.findAll());
        }
        return "todolist";
    }

    @GetMapping("/list2")
    public String listOfTodo(@ModelAttribute(value = "isActive") boolean bool, Model model) {
        List<Todo> activelist = new ArrayList<>();
        for (Todo todo : servTodo.findAll()) {
            if (todo.isDone() == bool) {
                activelist.add(todo);
            }
        }
        model.addAttribute("todos", activelist);
        return "todolist";
    }
    @GetMapping("/assignees")
    public String mapAssinees(Model model) {
        model.addAttribute("assignees", servAssign.findAll());
        return "assignees";
    }

    @GetMapping("/assignees/add")
    public String addAssignee(Model model) {
        model.addAttribute("newAssignee", new Assignee());
        return "addAssignee";
    }

    @PostMapping("/assignees/add")
    public String addNewAccount(@ModelAttribute(value = "name") String name,
                                @ModelAttribute(value = "email") String email) {
        servAssign.save(new Assignee(name,email));
        return "redirect:/assignees";
    }

    @GetMapping(value ="/assignees/{id}/delete")
    public ModelAndView deleteAssignee(@PathVariable long id) {
        servAssign.deleteById(id);
        return new ModelAndView("redirect:/assignees");
    }

    @GetMapping(value = "/assignees/{id}/update")
    public String editAssignee(@PathVariable long id,
                       Model model) {
        model.addAttribute("assignees", servAssign.findById(id));
        return "editAssignees";
    }

    @PostMapping(value = "assignees/update")
    public ModelAndView update(@RequestParam("name") String name,
                               @RequestParam("id") Long id) {
        Assignee assignee = servAssign.findById(id);
        assignee.setName(name);
        servAssign.save(assignee);
        return new ModelAndView("redirect:/assignees");
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
        servTodo.save(new Todo(title, urgent, done));
        return "redirect:/list";
    }

    @GetMapping(value ="/list/{id}/delete")
    public ModelAndView delete(@PathVariable long id) {
        servTodo.deleteById(id);
        return new ModelAndView("redirect:/list");
    }

    @GetMapping(value = "/list/{id}/update")
    public String edit(@PathVariable long id,
                       Model model) {
        model.addAttribute("todo", servTodo.findById(id));
        model.addAttribute("assignees", servAssign.findAll());
        return "edit";
    }


    @PostMapping(value = "/update")
    public ModelAndView update(@RequestParam("title") String title,
                               @RequestParam("id") Long id,
                               @RequestParam(value = "done", required = false, defaultValue = "false") boolean done,
                               @RequestParam(value = "urgent", required = false, defaultValue = "false") boolean urgent,
                               @RequestParam (value="assignees", required = false) String assigneeName) {
        Assignee assignee = servAssign.findByName(assigneeName);
        Todo todo = servTodo.findById(id);
        todo.setAssignee(assignee);
        todo.setTitle(title);
        todo.setDone(done);
        todo.setUrgent(urgent);
        servTodo.save(todo);
        return new ModelAndView("redirect:/list");
    }

    @PostMapping("/search")
    public String searchTodo(@RequestParam(value = "searchedtask", required = false,defaultValue = "") String title,
                             @RequestParam(value = "searcheddate",required = false,defaultValue = "") String date,
                             Model model) {
        boolean searchIsActive = true;
        if( !(title.length() == 0) ) {
            model.addAttribute("todos", servTodo.findByTitle(title));
        }
        if(!(date.length() == 0)) {
            model.addAttribute("todos", servTodo.findByDate(date));
        }
        return "todolist"; // jobba lenne ha a listre menne vissza -> és a linkbe bekerülni a keresett elem
    }
}

