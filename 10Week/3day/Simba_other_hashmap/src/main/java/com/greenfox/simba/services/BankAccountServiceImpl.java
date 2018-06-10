package com.greenfox.simba.services;

import com.greenfox.simba.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    public BankAccountServiceImpl() {
        createAccount();
    }

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    @Override
    public void add(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    @Override
    public ArrayList<BankAccount> getAllAccount() {
        return accounts;
    }

    @Override
    public void createAccount() {
        accounts.add(new BankAccount("Rafiki", 3200, "monkey", false, true));
        accounts.add(new BankAccount("Zazu", 1950, "bird", false, true));
        accounts.add(new BankAccount("Simba", 2000, "lion", true, true));
        accounts.add(new BankAccount("Pumbaa", 3200, "pig", false, false));
        accounts.add(new BankAccount("Timon", 1400, "meerkat", false, false));
    }

    @Override
    public void riseBalance(BankAccount selectedAccount) {
        for (BankAccount account : accounts) {
            if (account.getName().equals(selectedAccount.getName())) {
                if (account.isKing()) {
                    account.setBalance(100);
                } else {
                    account.setBalance(10);
                }
            }
        }
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }
}
