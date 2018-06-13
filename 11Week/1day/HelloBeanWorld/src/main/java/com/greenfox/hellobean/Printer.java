package com.greenfox.hellobean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Printer {

    private MyColor myColor;

    @Autowired
    public Printer(@Qualifier(value = "greyImpl") MyColor myColor) {
        System.out.println("helo");
        this.myColor = myColor;
    }

    public Printer() {
        System.out.println("letrejottem");
    }

    public void log(String message) {
        System.out.println(LocalDateTime.now() + " MY PRINTER SAYS --- " + message);
        myColor.printColor();
    }
}