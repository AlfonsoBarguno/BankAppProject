package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountServiceInterface {

    Optional<Account> findById(Long id);

    void changeBalance(Long id, BigDecimal amount);
}
