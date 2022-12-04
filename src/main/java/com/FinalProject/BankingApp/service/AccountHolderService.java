package com.FinalProject.BankingApp.service;

import com.FinalProject.BankingApp.model.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public void deleteAccountHolder(Long id) {

    }

    @Override
    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }
}
