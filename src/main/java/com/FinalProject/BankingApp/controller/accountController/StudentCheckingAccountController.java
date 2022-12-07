package com.FinalProject.BankingApp.controller.accountController;


import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.StudentCheckingAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentCheckingAccount")
public class StudentCheckingAccountController implements StudentCheckingAccountControllerInterface {

    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @Autowired
    AccountService accountService;


    @Override
    public StudentCheckingAccount createStudentCheckingAccount(@RequestBody @Valid StudentCheckingAccount studentCheckingAccount) {
        return studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount);
    }
}
