package com.greenfox.foxclub.controllers;



import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.models.Tricks;
import com.greenfox.foxclub.services.FoxListImpl;
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

    @Autowired
    private FoxListImpl foxList;
    @Autowired
    private Fox foxie;

    @GetMapping("/")
    public String mainPage( Model model) {
            model.addAttribute("currentFox", foxie);
            return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String loggedInPage(@ModelAttribute(value="name") String name) {
        foxie.setName(name);
        foxList.addFox(foxie);
        System.out.println(foxList.size());
        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutritionStore")
    public String nutritionStore(Model model) {
        model.addAttribute("foods",Food.values());
        model.addAttribute("drinks",Drink.values());
        return "nutrition";
    }

    @PostMapping("/nutritionStore")
    public String postNutPage(@ModelAttribute(value = "foods") String food,
                              @ModelAttribute(value = "drinks") String drink) {

        foxie.setDrink("water");
        foxie.setFood("salad");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        foxie.addAction(drink + " " + food +  " eated at " + dateFormat.format(date));

        return  "redirect:/?name=" + foxie.getName();
    }

    @GetMapping("/trickStore")
    public String trickStore(Model model) {
        model.addAttribute("tricks",Tricks.values() );
        return "trickstore";
    }

    @PostMapping("/trickStore")
    public String postNutPage(@ModelAttribute(value = "tricks") String trick) {
        foxie.addTrick(trick);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        foxie.addAction(trick + " learned at " + dateFormat.format(date) );
        return  "redirect:/?name=" + foxie.getName();
    }

    @GetMapping("/actionHistory")
    public String actionHist(Model model) {
    model.addAttribute("currentFox",foxie);
        return "actions";
    }
}
