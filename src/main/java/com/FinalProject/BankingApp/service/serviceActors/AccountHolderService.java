package com.FinalProject.BankingApp.service.serviceActors;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelSecurity.Role;
import com.FinalProject.BankingApp.repository.AccountHolderRepository;
import com.FinalProject.BankingApp.repository.AccountRepository;
import com.FinalProject.BankingApp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public AccountHolder createAccountHolder(AccountHolder accountHolder) {

        //encodear la contraseña
       accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));
       accountHolder = accountHolderRepository.save(accountHolder);
        //asignar role
        roleRepository.save(new Role("ACCOUNTHOLDER",accountHolder));

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


    //si solo hay una cuenta, retorna el balance. Pero si hay más de una, no encuentra el elemento.
    @Override
    public String checkAccountBalance(Long accountHolderId, Long accountId) {

        BigDecimal balance=BigDecimal.valueOf(0);

        AccountHolder accountHolder = accountHolderRepository.findById(accountHolderId)
                .orElseThrow(()->new IllegalArgumentException("The accountHolder does not exist."));

        List<Account> accountList = accountHolder.getAccountList();

        for(int i=0; i<accountList.size(); i++){

            if(accountId.equals(accountList.get(i).getId())){

                balance=accountList.get(i).getBalance();


            } else throw new NoSuchElementException("There is no such element.");

        }

        return "The balance of the account with id " + accountId + " is " + balance;
    }

    @Override
    public List<Account> findAccountList(Long accountHolderId) {
        return accountHolderRepository.findById(accountHolderId).get().getAccountList();
    }
}
