package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.repository.StudentCheckingAccountRepository;
import com.FinalProject.BankingApp.service.serviceAccount.StudentCheckingAccountInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckingAccountService implements StudentCheckingAccountInterface {

    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;


    @Override
    public StudentCheckingAccount createStudentCheckingAccount(StudentCheckingAccount studentCheckingAccount) {
        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }
}
