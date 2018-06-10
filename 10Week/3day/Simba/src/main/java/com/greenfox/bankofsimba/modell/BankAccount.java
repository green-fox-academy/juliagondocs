package com.greenfox.bankofsimba.modell;

public class BankAccount {

    private String name;
    private Double balance;
    private String animalType;
    private Integer id=0;
    private static int count=0;
    private boolean king = false;
    private String evil = "Y";

    public void setEvil(String evil) {
        this.evil = evil;
    }

    public String getEvil() {

        return evil;
    }

    public BankAccount(String name, Double balance, String animalType) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.id=count++;
    }

    public BankAccount() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setKing(boolean king) {
        this.king = king;
    }

    public boolean isKing() {
        return king;
    }

    public void setKing() {
        this.king=true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", animalType='" + animalType + '\'' +
                '}';
    }

    public void addToBalance() {
        if (isKing()) {
           balance+=100;
        } else {
            balance+=50;
        }
    }
}
