package com.FinalProject.BankingApp.controller.accountController;


import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.service.serviceAccount.AccountService;
import com.FinalProject.BankingApp.service.serviceAccount.StudentCheckingAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentCheckingAccount")
public class StudentCheckingAccountController implements StudentCheckingAccountControllerInterface {

    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @Autowired
    AccountService accountService;


    @Override
    @PostMapping("/create/{accountHolderId}")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentCheckingAccount createStudentCheckingAccount
            (@RequestBody @Valid StudentCheckingAccount studentCheckingAccount, @PathVariable Long accountHolderId) {
        return studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount, accountHolderId);
    }
}
