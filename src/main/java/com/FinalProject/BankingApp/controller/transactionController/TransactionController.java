package com.FinalProject.BankingApp.controller.transactionController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceTransaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transaction")
public class TransactionController implements TransactionControllerInterface {

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Override
    @PostMapping("/{sendingAccountId}/{receivingAccountId}/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction makeTransfer(@PathVariable Long sendingAccountId, @PathVariable Long receivingAccountId, @PathVariable BigDecimal amount) {

        Account sendingAccount = accountService.findById(sendingAccountId).
                orElseThrow(()->new IllegalArgumentException("The sending account does not exist."));
        Account receivingAccount = accountService.findById(receivingAccountId).
                orElseThrow(()->new IllegalArgumentException("The receiving account does not exist."));

        Transaction transaction = transactionService.transferMoney(sendingAccount,receivingAccount,amount);
        accountService.saveAccount(sendingAccount);
        accountService.saveAccount(receivingAccount);

        return transaction;


    }

    @PostMapping("thirdParty/{sendingAccountId}/{secretKeySendingAccount}/{receivingAccountId}/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction makeTransferThirdParty(@PathVariable Long sendingAccountId, @PathVariable String secretKeySendingAccount,
                                              @PathVariable Long receivingAccountId, @PathVariable BigDecimal amount,
                                              @RequestHeader("hashKey") String hashKey) {

        Account sendingAccount = accountService.findById(sendingAccountId).
                orElseThrow(()->new IllegalArgumentException("The sending account does not exist."));
        Account receivingAccount = accountService.findById(receivingAccountId).
                orElseThrow(()->new IllegalArgumentException("The receiving account does not exist."));

        Transaction transaction = transactionService.transferMoney(sendingAccount,receivingAccount,amount);
        accountService.saveAccount(sendingAccount);
        accountService.saveAccount(receivingAccount);

        return transaction;


    }


}
