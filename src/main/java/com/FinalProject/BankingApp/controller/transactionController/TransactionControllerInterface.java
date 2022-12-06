package com.FinalProject.BankingApp.controller.transactionController;

import com.FinalProject.BankingApp.model.modelTransaction.Transaction;

import java.math.BigDecimal;

public interface TransactionControllerInterface {

    Transaction makeTransfer (Long SendingAccountId, Long receivingAccountId, BigDecimal amount);
    }

