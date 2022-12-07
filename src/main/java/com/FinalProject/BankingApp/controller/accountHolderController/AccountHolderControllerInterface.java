package com.FinalProject.BankingApp.controller.accountHolderController;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AccountHolderControllerInterface {

    AccountHolder createAccountHolder (AccountHolder accountHolder);

    void deleteAccountHolder(Long id);

    List<AccountHolder> findAll();

    Optional<AccountHolder> findById(Long id);

    String checkBalance(Long accountHolderId, Long accountId);
}
