package com.greenfox.simba.services;

import com.greenfox.simba.models.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public interface BankAccountService {

    void add(BankAccount bankAccount);

    ArrayList<BankAccount> getAllAccount();

    void createAccount();

    void riseBalance(BankAccount selectedAccount);

}
