package com.greenfox.bankofsimba.service;

import com.greenfox.bankofsimba.modell.BankAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface BankService {
    void add(BankAccount bankAccount);

    ArrayList<BankAccount> getAllAccount();

    void createSimba();
    void createZebra();
    void createTimon();
    void createPumba();
    void createZazu();
    void createMufasa();

    String getSimbasFeatures();
}
