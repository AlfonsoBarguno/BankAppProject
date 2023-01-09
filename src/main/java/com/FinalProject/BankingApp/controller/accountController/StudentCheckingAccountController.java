package com.FinalProject.BankingApp.controller.accountController;


import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.StudentCheckingAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentCheckingAccount")
public class StudentCheckingAccountController implements StudentCheckingAccountControllerInterface {

    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @Autowired
    AccountService accountService;


    @Override
    @PostMapping("/create/{accountHolderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCheckingAccount createStudentCheckingAccount
            (@RequestBody @Valid StudentCheckingAccount studentCheckingAccount, @PathVariable Long accountHolderId) {
        return studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount, accountHolderId);
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

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);

    }
}
