package com.greenfox.foxclub.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Fox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    private List<Tricks> tricks ;
    private String food;


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

    private String drink;




    public Fox(String name) {
        this.name = name;
    }

    public Fox() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}