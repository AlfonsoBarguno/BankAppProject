package com.FinalProject.BankingApp.controller;

import com.FinalProject.BankingApp.model.AccountHolder;

import java.util.List;

public interface AccountHolderControllerInterface {

    AccountHolder createAccountHolder (AccountHolder accountHolder);

    void deleteAccountHolder(Long id);

    List<AccountHolder> findAll();
}
