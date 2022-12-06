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
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(Long id) {

        accountHolderService.deleteAccountHolder(id);

    }

    @Override
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> findAll() {
        return accountHolderService.findAll();
    }

    @Override
    @GetMapping("/findById")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<AccountHolder> findById(Long id) {
        return accountHolderService.findById(id);
    }


}
