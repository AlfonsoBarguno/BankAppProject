package com.FinalProject.BankingApp.controller.accountController;

import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;

public interface  SavingsAccountControllerInterface {

    SavingsAccount createSavingsAccount(SavingsAccount savingsAccount, Long accountHolderId);
}
