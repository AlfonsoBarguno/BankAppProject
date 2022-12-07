package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;

public interface CreditCardAccountServiceInterface {

    Account createCreditCardAccount (CreditCardAccount creditCardAccount);
}
