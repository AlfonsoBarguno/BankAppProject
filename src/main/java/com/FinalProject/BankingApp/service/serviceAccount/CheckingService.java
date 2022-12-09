package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount, Long accountHolderId) {

        AccountHolder accountHolder = accountHolderRepository
                .findById(accountHolderId).orElseThrow(()->new IllegalArgumentException("This accountHolder does not exist."));

        checkingAccount.setPrimaryOwner(accountHolder);
        List<Account> accountList = accountHolder.getAccountList();
        accountList.add(checkingAccount);

        accountHolderRepository.save(accountHolder);

        return checkingAccountRepository.save(checkingAccount);
    }

    @Override
    public void deleteCheckingAccount(Long id) {

        checkingAccountRepository.deleteById(id);

    }

    @Override
    public Optional<CheckingAccount> findById(Long id) {

       return checkingAccountRepository.findById(id);

    }

    public CheckingAccount substractBalance(Long id, BigDecimal amount) {

        CheckingAccount account = checkingAccountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        account.setBalance(account.getBalance().subtract(amount));

        account.applyPenaltyFee();

        return checkingAccountRepository.save(account);
    }
}
