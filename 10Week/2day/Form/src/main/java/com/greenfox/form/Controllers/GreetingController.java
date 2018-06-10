package com.greenfox.form.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting") // ez azért get mert itt adok neki erteket
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")  // greeting endpoint   ----- ez azert post, mert ez már értékadás után van
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result"; // result template használata
    }

}