package com.greenfox.foxclub.models;

import org.springframework.stereotype.Service;
@Service
public class GreenFoxImage {

    private String greenfox;

    public GreenFoxImage(){
        greenfox = "greenfox.png";
    }

    public String getGreenfox() {
        return greenfox;
    }
}
