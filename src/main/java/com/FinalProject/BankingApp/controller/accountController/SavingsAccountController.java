package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.controller.accountHolderController.AccountHolderControllerInterface;
import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.SavingsAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/savingsAccount")
public class SavingsAccountController implements SavingsAccountControllerInterface {


    @Autowired
    SavingsAccountService savingsAccountService;

    @Autowired
    AccountService accountService;


    @Override
    @PostMapping("/create/{accountHolderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public SavingsAccount createSavingsAccount(@RequestBody @Valid SavingsAccount savingsAccount,
                                               @PathVariable Long accountHolderId ) {
        return savingsAccountService.createSavingsAccount(savingsAccount, accountHolderId);
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Account> findById(@PathVariable Long id){

        savingsAccountService.applyPenaltyFee(id);
        savingsAccountService.applyInterestRate(id);

        return accountService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSavingsAccount(@PathVariable Long id) {

        accountService.deleteAccount(id);

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
