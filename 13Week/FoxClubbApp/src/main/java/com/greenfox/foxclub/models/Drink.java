package com.greenfox.foxclub.models;

public enum  Drink {
    DRINK1("Water"),
    DRINK2("Beer"),
    DRINK3("Cola"),
    DRINK4("Tea"),
    DRINK5("Bolero"),
    DRINK6("Mineral Water");


    private String drinkName;

    Drink(String drink) {
        this.drinkName = drink;
    }

    public String getDrinkName() {
        return drinkName;
    }
}
