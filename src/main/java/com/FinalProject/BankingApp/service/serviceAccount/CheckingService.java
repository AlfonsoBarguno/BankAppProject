package com.FinalProject.BankingApp.service.serviceAccount;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelAccounts.StudentCheckingAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.CheckingAccountRepository;
import com.FinalProject.BankingApp.repository.StudentCheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingService implements CheckingServiceInterface {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    StudentCheckingAccountService studentCheckingAccountService;

    @Override
    public CheckingAccount createCheckingAccount(CheckingAccount checkingAccount, Long accountHolderId) {

        AccountHolder accountHolder = accountHolderRepository
                .findById(accountHolderId).orElseThrow(()->new IllegalArgumentException("This accountHolder does not exist."));


        //Por alguna razón, no reconoce la dateOfBirth y, por lo tanto,
        //no asigna la studentAccount a los menores de 24, pero creo que
        //esta sería la lógica

        /*
        Period accountHolderAge = Period.between(accountHolder.getDateOfBirth(), LocalDate.now());

        if(accountHolderAge.getYears()<24){

            StudentCheckingAccount studentCheckingAccount =
                    new StudentCheckingAccount(checkingAccount.getBalance(),checkingAccount.getStatus(),
                            checkingAccount.getSecretKey(),checkingAccount.getPrimaryOwner(),checkingAccount.getSecondaryOwner(),
                            checkingAccount.getSendingTransactionList(),checkingAccount.getReceivingTransactionList(),
                            checkingAccount.getMinimumBalance(),BigDecimal.valueOf(0.0025));

        studentCheckingAccountService.createStudentCheckingAccount(studentCheckingAccount,accountHolderId);


        } else {*/


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

        if(amount.compareTo(BigDecimal.valueOf(0))==-1){

            throw new IllegalArgumentException("The amount must be over 0.");

        }

        CheckingAccount account = checkingAccountRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No account found."));

        account.setBalance(account.getBalance().subtract(amount));

        account.applyPenaltyFee();

        return checkingAccountRepository.save(account);
    }

    public void applyPenaltyFee(Long accountId){

        CheckingAccount checkingAccount= checkingAccountRepository.findById(accountId).
                orElseThrow(()-> new IllegalArgumentException("No account found."));

        checkingAccount.applyPenaltyFee();
    }
}
