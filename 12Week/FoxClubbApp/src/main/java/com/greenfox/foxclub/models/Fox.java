package com.greenfox.foxclub.models;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Fox {
    private String name;
    private List<String> tricks = new ArrayList<>();
    private String food;
    private String drink;

    public List<String> getActions() {
        return actions;
    }

    private List<String> actions = new ArrayList<>();

    public Fox() {
    }

    public Fox(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void addTrick(String trick) {
        tricks.add(trick);
    }

    public void addAction(String action) {
        actions.add(action);
    }
}