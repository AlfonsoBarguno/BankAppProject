package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Optional<Account> findById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        return Optional.ofNullable(account);
    }

    @Override
    public void changeBalance(Long id, BigDecimal amount) {

        Account account = accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        account.setBalance(account.getBalance().subtract(amount));

        accountRepository.save(account);
    }
}
