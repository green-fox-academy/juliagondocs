package com.greenfox.login.controllers;


import com.greenfox.login.models.Login;
import com.greenfox.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    LoginService loginService;

    @Autowired  // példányosítok
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("") // megnyitok egy oldalt, az index.html-t
    public String renderLoginPage() {
        return "index";
    }

    @PostMapping("/login") //azután hogy csinaltam valamit (ettől lesz post) atadok ket valtozot
    public String login(@ModelAttribute(value = "username") String userName,
                        @ModelAttribute(value = "password") String password) {

        loginService.login(userName, password);
        return "redirect:/profile/" + userName; // utana atiranyit ide
    }

    @GetMapping("/profile/{userName}")
    public String renderProfilePage(@PathVariable(value = "userName") String userName, Model model) {
        Login login = loginService.getUser(userName);
        model.addAttribute("login", login);
        return "profile";
    }
}
