package com.greenfox.foxes;

public enum Foods {
    FOOD1("Salad"),
    FOOD2("Pizza"),
    FOOD3("Hamburger"),
    FOOD4("Bacon"),
    FOOD5("Hot-Dog"),
    FOOD6("Chicken and rice");


    private String foodName;

    Foods(String food) {
        this.foodName = food;
    }

    public String getFoodName() {
        return foodName;
    }
}
