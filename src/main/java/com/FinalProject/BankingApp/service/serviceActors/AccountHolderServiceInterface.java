package com.FinalProject.BankingApp.service.serviceActors;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AccountHolderServiceInterface {

    AccountHolder createAccountHolder (AccountHolder accountHolder);
    void deleteAccountHolder(Long id);

    Optional<AccountHolder> findById(Long id);

    List<AccountHolder> findAll();

    String checkAccountBalance (Long AccountHolderId, Long accountId);
}
