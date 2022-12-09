package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;

import java.util.Optional;

public interface CheckingServiceInterface {

    CheckingAccount createCheckingAccount (CheckingAccount checkingAccount, Long accountHolderId);
    void deleteCheckingAccount (Long id);

    Optional<CheckingAccount> findById(Long id);
}
