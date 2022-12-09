package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardAccountService implements CreditCardAccountServiceInterface{

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public Account createCreditCardAccount(CreditCardAccount creditCardAccount, Long accountHolderId) {

        AccountHolder accountHolder = accountHolderRepository
                .findById(accountHolderId).orElseThrow(()->new IllegalArgumentException("This accountHolder does not exist."));

        creditCardAccount.setPrimaryOwner(accountHolder);
        List<Account> accountList = accountHolder.getAccountList();
        accountList.add(creditCardAccount);

        accountHolderRepository.save(accountHolder);

        return creditCardRepository.save(creditCardAccount);
    }
}
