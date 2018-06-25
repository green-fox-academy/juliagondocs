package com.greenfox.foxclub.models;

public enum  Tricks {
    TRICKS1("Learn HTML"),
    TRICKS2("Do Spring Application"),
    TRICKS3("Learn Kotlin"),
    TRICKS4("Use python"),
    TRICKS5("make statistics with R"),
    TRICKS6("Learn super up-to-date fortran :) ");

    private String trickName;

    Tricks(String trick) {
        this.trickName = trick;
    }

    public String getTrickName() {
        return trickName;
    }
}
