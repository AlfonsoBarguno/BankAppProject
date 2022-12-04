package com.FinalProject.BankingApp.service;

import com.FinalProject.BankingApp.model.CheckingAccount;
import com.FinalProject.BankingApp.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    CheckingRepository checkingRepository;

    @Override
    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount) {
        return checkingRepository.save(checkingAccount);
    }

    @Override
    public void deleteCheckingAccount(Long id) {

    }
}
