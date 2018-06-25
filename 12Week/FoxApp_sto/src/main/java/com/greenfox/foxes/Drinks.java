package com.greenfox.foxes;

public enum Drinks {
    DRINK1("Water"),
    DRINK2("Beer"),
    DRINK3("Cola"),
    DRINK4("Tea"),
    DRINK5("Bolero"),
    DRINK6("Mineral Water");


    private String drinkName;

    Drinks(String drink) {
        this.drinkName = drink;
    }

    public String getDrinkName() {
        return drinkName;
    }
}
