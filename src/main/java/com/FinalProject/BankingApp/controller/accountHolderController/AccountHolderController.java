package com.FinalProject.BankingApp.controller.accountHolderController;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.service.serviceActors.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountHolder")
public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderService accountHolderService;

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {

        return accountHolderService.createAccountHolder(accountHolder);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(@PathVariable Long id) {

        accountHolderService.deleteAccountHolder(id);

    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAll() {
        return accountHolderService.findAll();
    }

    @Override
    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<AccountHolder> findById(@PathVariable Long id) {
        return accountHolderService.findById(id);
    }

    @Override
    @GetMapping("/checkBalance/{accountHolderId}/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public String checkBalance(@PathVariable Long accountHolderId, @PathVariable Long accountId) {
        return accountHolderService.checkAccountBalance(accountHolderId,accountId);
    }

    //da como resultado null; posible problema en la búsqueda del accountList


}
