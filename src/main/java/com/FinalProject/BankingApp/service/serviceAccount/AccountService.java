package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Optional<Account> findById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        return Optional.ofNullable(account);
    }

    @Override
    public Account substractBalance(Long id, BigDecimal amount) {

        if(amount.compareTo(BigDecimal.valueOf(0))==-1){

            throw new IllegalArgumentException("The amount must be over 0.");

        }

        Account account = accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        account.setBalance(account.getBalance().subtract(amount));

        return accountRepository.save(account);
    }

    @Override
    public Account addBalance(Long id, BigDecimal amount) {

        if(amount.compareTo(BigDecimal.valueOf(0))==-1){

            throw new IllegalArgumentException("The amount must be over 0.");

        }

        Account account = accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        account.setBalance(account.getBalance().add(amount));

       return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {

        accountRepository.deleteById(id);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Transaction> getSendingTransactionList(Long accountId){

        Account account = accountRepository.findById(accountId).orElseThrow(()->new IllegalArgumentException("No account found."));

        List<Transaction> sendingTransactionList = account.getSendingTransactionList();

        return sendingTransactionList;
    }

    public List<Transaction> getReceivingTransactionList(Long accountId){

        Account account = accountRepository.findById(accountId).orElseThrow(()->new IllegalArgumentException("No account found."));

        List<Transaction> receivingTransactionList = account.getReceivingTransactionList();

        return receivingTransactionList;
    }
}
