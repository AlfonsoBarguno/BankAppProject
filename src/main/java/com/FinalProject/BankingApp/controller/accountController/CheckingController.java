package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.CheckingService;
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
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount createCheckingAccount(@RequestBody CheckingAccount checkingAccount) {
         return checkingService.createCheckingAccount(checkingAccount);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCheckingAccount(@PathVariable Long id) {

        checkingService.deleteCheckingAccount(id);

    }

    @Override
    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<CheckingAccount> findById(@PathVariable Long id) {
        return checkingService.findById(id);
    }

    @Override
    @PatchMapping("/substractBalance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void substractBalanceCheckingAccount(@PathVariable Long id, @RequestParam BigDecimal amount) {

        accountService.changeBalance(id,amount);


    }
}
