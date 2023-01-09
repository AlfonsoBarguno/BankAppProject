package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.CreditCardAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Account> findById(@PathVariable Long id){

        creditCardAccountService.applyInterestRate(id);

        return accountService.findById(id);
    }

    @GetMapping("/sendingTransactionList/{accountId}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Transaction> getSendingTransactionList(@PathVariable Long accountId){

        return accountService.getSendingTransactionList(accountId);
    }

    @GetMapping("/receivingTransactionList/{accountId}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Transaction> getReceivingTransactionList(@PathVariable Long accountId){

        return accountService.getReceivingTransactionList(accountId);
    }
}
