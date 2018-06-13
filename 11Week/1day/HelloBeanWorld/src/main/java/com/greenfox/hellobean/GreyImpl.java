package com.greenfox.hellobean;

import org.springframework.stereotype.Service;

@Service
public class GreyImpl implements MyColor {
    @Override
    public void printColor() {
        System.out.println("grey");
    }
}
