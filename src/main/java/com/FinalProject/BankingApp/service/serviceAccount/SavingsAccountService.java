package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsAccountService implements SavingsAccountServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Override
    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount, Long accountHolderId) {

        AccountHolder accountHolder = accountHolderRepository
                .findById(accountHolderId).orElseThrow(()->new IllegalArgumentException("This accountHolder does not exist."));

        savingsAccount.setPrimaryOwner(accountHolder);
        List<Account> accountList = accountHolder.getAccountList();
        accountList.add(savingsAccount);

        accountHolderRepository.save(accountHolder);

        return savingsRepository.save(savingsAccount);
    }

    public void applyPenaltyFee(Long accountId){

        SavingsAccount savingsAccount= savingsRepository.findById(accountId).get();

        savingsAccount.applyPenaltyFee();
    }

    public void applyInterestRate(Long accountId){

        SavingsAccount savingsAccount= savingsRepository.findById(accountId).get();

        savingsAccount.applyInterestRate();
    }
}
