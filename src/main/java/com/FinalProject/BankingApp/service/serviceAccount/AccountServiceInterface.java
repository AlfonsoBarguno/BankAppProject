package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;

import java.math.BigDecimal;
import java.util.Optional;

public interface AccountServiceInterface {

    Optional<Account> findById(Long id);

    Account substractBalance(Long id, BigDecimal amount);

    Account addBalance(Long id, BigDecimal amount);

    void deleteAccount(Long id);

    Account saveAccount(Account account);
}
