package com.greenfox.utilities.controller;

import com.greenfox.utilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private UtilityService utilityService;

    @Autowired
    public WebController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("useful")
    public String useful() {
        return "useful";
    }

    @GetMapping("useful/colored")
    public String coloredBackground(Model model) {
        model.addAttribute("background", utilityService.randomColor());
        return "colored";
    }

    @RequestMapping("useful/email")
    public String email(@RequestParam("email") String email, Model model) {
        model.addAttribute("valideemail", utilityService.validateEmail(email));
        model.addAttribute("email", email);
        return "validateemail";
    }


    @RequestMapping("useful/decoding")
    public String email_de(@RequestParam("text") String text,
                        @RequestParam("number") int number, Model model) {
        model.addAttribute("hiddentext", utilityService.caesar(text, -number));
//        model.addAttribute("number", utilityService.isPositive(number));
        return "encode";
    }


    @RequestMapping("useful/encoding")
    public String email_en(@RequestParam("text") String text,
                        @RequestParam("number") int number, Model model) {
        model.addAttribute("hiddentext", utilityService.caesar(text, number));
        //       model.addAttribute("number", utilityService.isPositive(number));
        return "encode";
    }

}
