package com.greenfox.springstart.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class WebCounter {
    AtomicLong atomicLong = new AtomicLong(1);

    @RequestMapping("/web/greeting")
    public String greeting(Model model, @RequestParam("name") String name) {
        model.addAttribute("name", name);
        long counter = atomicLong.getAndIncrement();
        model.addAttribute("id", counter);
        return "greeting";
    }
}
