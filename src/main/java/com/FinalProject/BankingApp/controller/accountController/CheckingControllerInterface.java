package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;

import java.math.BigDecimal;
import java.util.Optional;

public interface CheckingControllerInterface {

    CheckingAccount createCheckingAccount(CheckingAccount checkingAccount);
    void deleteCheckingAccount(Long id);

    Optional<CheckingAccount> findById(Long id);

    void substractBalanceCheckingAccount(Long id, BigDecimal amount);
}
