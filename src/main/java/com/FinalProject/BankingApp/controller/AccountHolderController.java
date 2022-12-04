package com.FinalProject.BankingApp.controller;

import com.FinalProject.BankingApp.model.AccountHolder;
import com.FinalProject.BankingApp.service.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderService accountHolderService;

    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return null;
    }

    @Override
    public void deleteAccountHolder(Long id) {

    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAll() {
        return accountHolderService.findAll();
    }
}
