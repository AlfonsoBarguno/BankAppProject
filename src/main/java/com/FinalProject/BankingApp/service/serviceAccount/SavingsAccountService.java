package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;
import com.FinalProject.BankingApp.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService implements SavingsAccountServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;
    @Override
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
        return savingsRepository.save(savingsAccount);
    }
}
