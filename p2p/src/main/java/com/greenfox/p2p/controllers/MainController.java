package com.greenfox.p2p.controllers;

import com.greenfox.p2p.models.User;
import com.greenfox.p2p.services.MessageService;
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
    private MessageService messageService;

    @Autowired
    public MainController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "registration";
    }

    @PostMapping(value = "/register")
    public String validateRegistration(@ModelAttribute(value = "username") String name,
                                       Model model) {
        if (name.length() != 0) {
            if (userService.isValidRegistration(name) && userService.findAll().size() < 1) {
                userService.saveNewUser(new User(name));
                messageService.initMessage();
                return "redirect:/";
            } else {
                model.addAttribute("error", "select new username, this is taken");
                return "registration";
            }
        } else {
            model.addAttribute("error", "The username field is empty");
            return "registration";
        }
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("user", userService.findById(1L));
        model.addAttribute("messages",messageService.findAll());
        return "main";
    }

    @PostMapping("/")
    public String postMainPage(@ModelAttribute(value = "name") String name,
                               Model model) {
        userService.updateUser(name);
        return "redirect:/";
    }
}
