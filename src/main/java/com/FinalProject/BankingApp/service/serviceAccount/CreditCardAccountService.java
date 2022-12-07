package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import com.FinalProject.BankingApp.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardAccountService implements CreditCardAccountServiceInterface{

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public Account createCreditCardAccount(CreditCardAccount creditCardAccount) {
        return creditCardRepository.save(creditCardAccount);
    }
}
