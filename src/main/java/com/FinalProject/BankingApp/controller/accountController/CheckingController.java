package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.CheckingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/checkingAccount")
public class CheckingController implements CheckingControllerInterface {

    @Autowired
    CheckingService checkingService;

    @Autowired
    AccountService accountService;

    @Override
    @PostMapping("/create/{accountHolderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount createCheckingAccount(@RequestBody @Valid CheckingAccount checkingAccount,
                                                 @PathVariable Long accountHolderId) {
         return checkingService.createCheckingAccount(checkingAccount, accountHolderId);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCheckingAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);

    }
    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Account> findById(@PathVariable Long id) {

        checkingService.applyPenaltyFee(id);

        return accountService.findById(id);
    }


}
