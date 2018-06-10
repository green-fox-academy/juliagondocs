package com.greenfox.simba.controllers;

import com.greenfox.simba.models.BankAccount;
import com.greenfox.simba.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/multipleaccounts")
    public String selectAccount(Model model) {
        String str = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("html", str);
        model.addAttribute("accounts", bankAccountService.getAllAccount());
        model.addAttribute("selectedAccount", new BankAccount());
        return "bankofsimba";
    }

    @GetMapping("/newAccount")
    public String getNewAccount(Model model) {
        model.addAttribute("newAccount", new BankAccount());
        return "newAccount";
    }

    @PostMapping("/multipleaccounts")
    public String riseTheBalance(@ModelAttribute BankAccount selectedAccount) {
        bankAccountService.riseBalance(selectedAccount);
        return "redirect:/multipleaccounts";
    }

    @PostMapping("/newAccount")
    public String addNewAccount(@ModelAttribute BankAccount newAccount) {
        bankAccountService.add(newAccount);
        return "redirect:/multipleaccounts";
    }
}