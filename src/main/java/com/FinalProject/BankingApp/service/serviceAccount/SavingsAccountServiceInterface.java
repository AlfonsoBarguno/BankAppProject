package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;

import java.util.Optional;

public interface SavingsAccountServiceInterface {

    SavingsAccount createSavingsAccount (SavingsAccount savingsAccount, Long accountHolderId);

}
