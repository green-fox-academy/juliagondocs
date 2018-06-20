package com.greenfox.foxclub.models;

public enum Food {
    FOOD1("Salad"),
    FOOD2("Pizza"),
    FOOD3("Hamburger"),
    FOOD4("Bacon"),
    FOOD5("Hot-Dog"),
    FOOD6("Chicken and rice");


    private String foodName;

    Food(String food) {
        this.foodName = food;
    }

    public String getFoodName() {
        return foodName;
    }
}
