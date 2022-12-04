package com.FinalProject.BankingApp.service;

import com.FinalProject.BankingApp.model.AccountHolder;

import java.util.List;

public interface AccountHolderServiceInterface {

    AccountHolder createAccountHolder (AccountHolder accountHolder);
    void deleteAccountHolder(Long id);

    List<AccountHolder> findAll();
}
