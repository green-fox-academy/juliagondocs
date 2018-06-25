package com.greenfox.foxes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    GreenfoxImages myImages;
    @Autowired
    Fox myFox;
    @Autowired
    Foxlist myFoxlist;

    @GetMapping(value = "/")
    public String mainPage(@RequestParam(name = "foxname", required = false) String foxname, Model model) {
        model.addAttribute("greenfox", myImages.getGreenfox());
        model.addAttribute("foods", Foods.values());
        model.addAttribute("drinks", Drinks.values());
        if (foxname == null) {
            model.addAttribute("fox", myFox);
            return "Login";
        } else {
            model.addAttribute("currentFox", myFoxlist.getFoxList().get(myFoxlist.getFoxIndex(foxname)));
            return "Index";
        }
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "Login";
    }

    @PostMapping(value = "/login")
    public String loggedInPage(@ModelAttribute Fox filledFox) {
        myFoxlist.addFox(filledFox);
        return "redirect:/?foxname=" + filledFox.getName();
    }
}