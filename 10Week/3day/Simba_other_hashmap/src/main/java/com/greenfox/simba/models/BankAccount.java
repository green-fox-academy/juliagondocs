package com.greenfox.simba.models;

public class BankAccount {
    private String name;
    private double balance;
    private String animalType;
    private String currency;
    private boolean isKing;
    private boolean godOne;


    public BankAccount() {
        this.currency = "Silver dog";
        this.isKing = false;
        this.godOne = true;
    }

    public BankAccount(String name, double balance, String animalType, boolean isKing, boolean godOne) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = "Silver dog";
        this.isKing = isKing;
        this.godOne = godOne;
    }

    public boolean isGodOne() {
        return godOne;
    }

    public void setGodOne(boolean godOne) {
        this.godOne = godOne;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
