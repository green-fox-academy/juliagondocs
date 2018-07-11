package com.greenfox.p2p.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/register")
    public String getRegisterPage (){
        return "registration";
    }

    @PostMapping(value = "/register")
    public String validateRegistration(@ModelAttribute(value = "username") String name) {
        System.out.println(name);
            return "redirect:/main";
    }
}
