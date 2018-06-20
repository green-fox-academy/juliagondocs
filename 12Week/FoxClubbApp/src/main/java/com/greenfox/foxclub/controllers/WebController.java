package com.greenfox.foxclub.controllers;



import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.services.FoxListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
        System.out.println(drink + " " + food );
        //foxie.setDrink("water");
        //foxie.setFood("salad");
        return  "redirect:/";
    }

}
