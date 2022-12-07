package com.FinalProject.BankingApp.controller.adminController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/admin")
public class AdminController implements AdminControllerInterface{


    @Autowired
    AccountService accountService;


    //un método con pathVariable y requestParam
    @Override
    @PatchMapping("/substract/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public Account substractBalance(@PathVariable Long accountId, @RequestParam BigDecimal amount) {
        return accountService.substractBalance(accountId,amount);
    }

    //otro con dos requestParam
    @Override
    @PatchMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Account addBalance(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        return accountService.addBalance(accountId,amount);
    }
}
