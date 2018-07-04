package com.greenfox.foxclub.controllers;


import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.Tricks;
import com.greenfox.foxclub.services.FoxServiceImpl;
import com.greenfox.foxclub.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class WebController {

    private final FoxServiceImpl foxservice;
    private final UserServiceImpl userservice;

    @Autowired
    public WebController(FoxServiceImpl foxservice, UserServiceImpl userservice) {
        this.foxservice = foxservice;
        this.userservice = userservice;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        System.out.println(foxservice.getCurrentFox().getName());
        System.out.println(foxservice.getCurrentFox().getDrink());
        model.addAttribute("currentFox", foxservice.getCurrentFox());
        return "index";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String validateRegistration(@ModelAttribute(value = "name") String name,
                                       @ModelAttribute(value = "petname") String petName,
                                       @ModelAttribute(value = "pswd1") String pswd1,
                                       @ModelAttribute(value = "pswd2") String pswd2, Model model) {
        if (userservice.isValidRegistration(name, pswd1, pswd2)) {
            foxservice.saveNewFox(petName); // elmentem a Foxom
            userservice.saveNewAccountWithFox(name, pswd1, foxservice.findByName(petName));
            return "redirect:/login";
        } else {
            model.addAttribute("errors", userservice.whatIsWrongWithTheRegistration(name, pswd1, pswd2));
            System.out.println(userservice.whatIsWrongWithTheRegistration(name, pswd1, pswd2).size());
            return "registration";
        }
    }

    @PostMapping(value = "/login")
    public String loggedInPage(@ModelAttribute(value = "username") String username) {
        if (userservice.isContainsUserName(username)) {
            Fox foxie = foxservice.findByName(userservice.findByName(username).getFox().getName());
            foxservice.setCurrentFox(foxie);
        } else {
            return "redirect:/login";
        }
        return "redirect:/?name=" + username;
    }

    @GetMapping("/nutritionStore")
    public String nutritionStore(Model model) {
        model.addAttribute("foods", Food.values());
        model.addAttribute("drinks", Drink.values());
        return "nutrition";
    }

    @PostMapping("/nutritionStore")
    public String postNutPage(@ModelAttribute(value = "foods") String food,
                              @ModelAttribute(value = "drinks") String drink) {
        foxservice.setNutritionsToFox(foxservice.getCurrentFox(),drink,food);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        //foxservice.getCurrentFox().addAction(drink + " " + food + " eated at " + dateFormat.format(date));
        return "redirect:/?name=" + foxservice.getCurrentFox().getName();
    }

    @GetMapping("/trickStore")
    public String trickStore(Model model) {
        model.addAttribute("tricks", Tricks.values());
        return "trickstore";
    }

    @PostMapping("/trickStore")
    public String postNutPage(@ModelAttribute(value = "tricks") String trick) {
        foxservice.setTrickToFox(foxservice.getCurrentFox(),trick);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        //    foxie.addAction(trick + " learned at " + dateFormat.format(date));
        return "redirect:/?name=" + foxservice.getCurrentFox().getName();
    }

    @GetMapping("/actionHistory")
    public String actionHist(Model model) {
        model.addAttribute("currentFox", foxservice.findByName("Fox"));
        return "actions";
    }
}
