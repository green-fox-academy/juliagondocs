package com.greenfoxacademy.springstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class Controller {
    @GetMapping(value="/hello")
    @ResponseBody
    public String getSomethingBack() {
        return "hello world!";
    }

    private String name;

    @RequestMapping("/cicak")
    public ArrayList<String> getCicaNames() {
        return new ArrayList<String>(Arrays.asList(
                "Cirmi",
                "Cirmus",
                "Dogi"
        ));
    }


}