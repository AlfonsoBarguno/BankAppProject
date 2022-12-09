package com.FinalProject.BankingApp.service.serviceTransaction;

import com.FinalProject.BankingApp.model.modelAccounts.Account;
import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.model.modelActors.Status;
import com.FinalProject.BankingApp.repository.AccountRepository;
import com.FinalProject.BankingApp.repository.CheckingAccountRepository;
import com.FinalProject.BankingApp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    AccountRepository accountRepository;


    public Transaction transferMoney(Account sendingAccount, Account receivingAccount, BigDecimal amount) {

        //1. Ver si existen las cuentas
        //2. Ver si tienen fondos
        //3.Realizar transacción
        //4.Actualizar datos

        Transaction transaction;

        if (accountRepository.existsById(sendingAccount.getId())
                || accountRepository.existsById(receivingAccount.getId())
                || sendingAccount.getStatus() == Status.ACTIVE
                || receivingAccount.getStatus() == Status.ACTIVE) {

            System.out.println("Both accounts exist and are active.");


            if (sendingAccount.getBalance().compareTo(amount) > 0) {
                sendingAccount.setBalance(sendingAccount.getBalance().subtract(amount));
                receivingAccount.setBalance(receivingAccount.getBalance().add(amount));

                transaction = new Transaction(sendingAccount, receivingAccount, amount);

                transactionRepository.save(transaction);

                List<Transaction> sendingTransaction = sendingAccount.getSendingTransactionList();
                sendingTransaction.add(transaction);

                List<Transaction> receivingTransaction = receivingAccount.getReceivingTransactionList();
                receivingTransaction.add(transaction);


                accountRepository.save(sendingAccount);
                accountRepository.save(receivingAccount);

            } else throw new IllegalArgumentException("Not enough funds in sending account");


        } else throw new NoSuchElementException("One of the accounts does not exists.");
        //lanzar ReponseStatusException



        System.out.println("Transaction done");
        return transaction;
    }


    public Transaction saveTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }


    public Optional<Transaction> getById(Long id) {

        Optional<Transaction> opTrans = Optional.ofNullable(transactionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Insert valid id.")));

        return opTrans;
    }


}
