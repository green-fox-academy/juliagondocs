package com.greenfoxacademy.springstart.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRESTController {

    private AtomicLong greetingId = new AtomicLong(0L);
    List<Greetings> greetings = new ArrayList<>();

    @RequestMapping(value = "/greeting")
    public String greeting(@RequestParam("name") String name) {
        Greetings greet = new Greetings(greetingId.getAndIncrement(), " Helloka " + name);
        greetings.add(greet);
        return greetings.toString();
    }


}
