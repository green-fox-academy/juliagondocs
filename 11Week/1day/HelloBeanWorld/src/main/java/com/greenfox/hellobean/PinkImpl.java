package com.greenfox.hellobean;

import org.springframework.stereotype.Service;

@Service
public class PinkImpl implements MyColor {
    @Override
    public void printColor() {
        System.out.println("pink");
    }
}