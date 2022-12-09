package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.CreditCardAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController implements CreditCardControllerInterface{


    @Autowired
    AccountService accountService;

    @Autowired
    CreditCardAccountService creditCardAccountService;

    @Override
    @PostMapping("/create/{accountHolderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCreditCardAccount(@RequestBody @Valid CreditCardAccount creditCardAccount,
                                           @PathVariable Long accountHolderId) {
        return creditCardAccountService.createCreditCardAccount(creditCardAccount, accountHolderId);
    }
}
