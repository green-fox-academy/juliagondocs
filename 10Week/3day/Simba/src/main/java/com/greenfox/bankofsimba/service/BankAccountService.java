package com.greenfox.bankofsimba.service;

import com.greenfox.bankofsimba.modell.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BankAccountService implements BankService {

    public BankAccountService() {
        createAccount();
    }

    @Override
    public void createAccount() {
        createSimba();
        createZebra();
        createTimon();
        createPumba();
        createZazu();
        createMufasa();
    }

    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    @Override
    public void add(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    @Override
    public ArrayList<BankAccount> getAllAccount() {
        return bankAccounts;
    }

    @Override
    public void createSimba() {
        BankAccount simba = new BankAccount("Simba", 2000.0, "LION");
        simba.setKing();
        bankAccounts.add(simba);
    }

    @Override
    public void createZebra() {
        bankAccounts.add(new BankAccount("Zebra", 2000.0, "ZEBRA"));
    }

    @Override
    public String getSimbasFeatures() {
        bankAccounts.add(new BankAccount("Simba", 2000.0, "oroszlán"));
        return bankAccounts.get(0).toString();
    }

    @Override
    public void createTimon() {
        bankAccounts.add(new BankAccount("Timon", 4000.0, "MEERKATS"));
    }

    @Override
    public void createPumba() {
        bankAccounts.add(new BankAccount("Pumba", 3000.0, "WARTHOG"));
    }

    @Override
    public void createZazu() {
        bankAccounts.add(new BankAccount("Zazu", 5000.0, "PARROT"));
    }

    @Override
    public void createMufasa() {
        BankAccount mufasa = new BankAccount("Mufasa", 1000.0, "LION");
        mufasa.setEvil("N");
        bankAccounts.add(mufasa);
    }

    public void saveNewAccount(String name, Double balance, String animalType) {
        BankAccount account = new BankAccount(name, balance, animalType);
        bankAccounts.add(account);
    }

}
