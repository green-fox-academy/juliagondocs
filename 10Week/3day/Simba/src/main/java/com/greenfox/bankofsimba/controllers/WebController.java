package com.greenfox.bankofsimba.controllers;

import com.greenfox.bankofsimba.modell.BankAccount;
import com.greenfox.bankofsimba.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final BankService bankService;

    @Autowired
    public WebController(BankService bankService) {
        this.bankService = bankService;
    }


    @GetMapping("/show")
    @ResponseBody
    public String getAllAccount() {
        bankService.createSimba();
        return bankService.getSimbasFeatures();
    }

    @GetMapping("/msg")
    public String message(Model model) {
        String msg = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("string", msg);
        return "bankaccount";
    }

    @GetMapping("/accounts")
    public String getAllAccount(Model thymeLeafModel) {
        thymeLeafModel.addAttribute("accounts", bankService.getAllAccount());
        thymeLeafModel.addAttribute("selectedaccount", new BankAccount());
        return "bankaccount";
    }

    @GetMapping("/newaccount")
    public String getNewAccount(Model model) {
        model.addAttribute("newAccount", new BankAccount());
        return "newaccount";
    }

    @PostMapping("/accounts")
    public String modifySelectedElement(@ModelAttribute BankAccount selectedAccount,Model model) {
        for (BankAccount account : bankService.getAllAccount()) {
            if (account.getName().equals(selectedAccount.getName())) {
                account.addToBalance();
            }
        }
        model.addAttribute("accounts", bankService.getAllAccount());
        return "redirect:/accounts";
    }


    @PostMapping("/newaccount")
    public String addNewAccount(@ModelAttribute(value = "name") String name,
                               @ModelAttribute(value = "balance") Double balance,
                                @ModelAttribute(value = "animalType") String animalType) {
        bankService.add(new BankAccount(name,balance,animalType));
        return "redirect:/accounts";
    }
}
