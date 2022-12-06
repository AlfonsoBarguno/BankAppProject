package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Override
    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
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
}
