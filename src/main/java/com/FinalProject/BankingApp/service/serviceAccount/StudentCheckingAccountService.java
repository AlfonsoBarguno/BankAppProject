package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.StudentCheckingAccountRepository;
import com.FinalProject.BankingApp.service.serviceAccount.StudentCheckingAccountInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCheckingAccountService implements StudentCheckingAccountInterface {

    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;


    @Override
    public StudentCheckingAccount createStudentCheckingAccount(StudentCheckingAccount studentCheckingAccount, Long accountHolderId) {

        AccountHolder accountHolder = accountHolderRepository
                .findById(accountHolderId).orElseThrow(()->new IllegalArgumentException("This accountHolder does not exist."));

        //accountHolder= checkingAccount.getPrimaryOwner();
        studentCheckingAccount.setPrimaryOwner(accountHolder);
        List<Account> accountList = accountHolder.getAccountList();
        accountList.add(studentCheckingAccount);

        accountHolderRepository.save(accountHolder);
        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }
}
