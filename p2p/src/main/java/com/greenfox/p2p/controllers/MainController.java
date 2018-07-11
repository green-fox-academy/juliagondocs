package com.greenfox.p2p.controllers;

import com.greenfox.p2p.models.User;
import com.greenfox.p2p.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage (){
        return "registration";
    }

    @PostMapping(value = "/register")
    public String validateRegistration(@ModelAttribute(value = "username") String name,
                                       Model model) {
        if (userService.isValidRegistration(name)) {
            userService.saveNewUser(new User(name));
            return "redirect:/register";
        } else {
            model.addAttribute("error", "select new username, this is taken");
            return "registration";
        }
    }
}
