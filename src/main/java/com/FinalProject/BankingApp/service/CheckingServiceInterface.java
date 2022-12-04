package com.FinalProject.BankingApp.service;

import com.FinalProject.BankingApp.model.CheckingAccount;

public interface CheckingServiceInterface {

    CheckingAccount createCheckingAccount (CheckingAccount checkingAccount);
    void deleteCheckingAccount (Long id);
}
