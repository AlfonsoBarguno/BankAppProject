package com.FinalProject.BankingApp.controller.adminController;

import com.FinalProject.BankingApp.model.modelAccounts.Account;

import java.math.BigDecimal;

public interface AdminControllerInterface {

    Account substractBalance(Long accountHolderId, BigDecimal amount);
    Account addBalance(Long accountHolderId, BigDecimal amount);

}
