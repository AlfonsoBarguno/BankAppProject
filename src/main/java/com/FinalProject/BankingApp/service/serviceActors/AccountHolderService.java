package com.FinalProject.BankingApp.service.serviceActors;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public void deleteAccountHolder(Long id) {

        accountHolderRepository.deleteById(id);

    }

    @Override
    public Optional<AccountHolder> findById(Long id) {
        return accountHolderRepository.findById(id);
    }

    @Override
    public List<AccountHolder> findAll() {
        return accountHolderRepository.findAll();
    }

    @Override
    public String checkAccountBalance(Long accountHolderId, Long accountId) {

        BigDecimal balance = null;

        AccountHolder accountHolder = accountHolderRepository.findById(accountHolderId).get();

        List<Account> accountList = accountHolder.getAccountList();

        for(int i=0; i<accountList.size(); i++){

            if(accountId.equals(accountList.get(i).getId())){

                balance=accountList.get(i).getBalance();


            } else throw new NoSuchElementException("There is no such element.");

        }

        return "The balance of the account with id " + accountId + " is " + balance;
    }
}
