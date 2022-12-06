package com.FinalProject.BankingApp.service.serviceActors;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        accountHolderRepository.deleteById(id);

    }

    @Override
    public Optional<AccountHolder> findById(Long id) {
        return accountHolderRepository.findById(id);
    }

    @Override
    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }
}
