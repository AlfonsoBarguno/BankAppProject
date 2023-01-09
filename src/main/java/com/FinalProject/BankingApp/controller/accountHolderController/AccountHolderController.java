package com.FinalProject.BankingApp.controller.accountHolderController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelSecurity.Role;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.repository.BankUserRepository;
import com.FinalProject.BankingApp.repository.RoleRepository;
import com.FinalProject.BankingApp.service.serviceActors.AccountHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountHolder")
public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderService accountHolderService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BankUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody @Valid AccountHolder accountHolder) {

        String encodedPassword = passwordEncoder.encode(accountHolder.getPassword());
        accountHolder.setPassword(encodedPassword);
        accountHolder = userRepository.save(accountHolder);
        Role role = roleRepository.save(new Role("USER", accountHolder));

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

    @Override
    @GetMapping("/findAccountList/{accountHolderId}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Account> findAccountList(@PathVariable Long accountHolderId) {
        return accountHolderService.findAccountList(accountHolderId);
    }



    //da como resultado null; posible problema en la búsqueda del accountList




}
