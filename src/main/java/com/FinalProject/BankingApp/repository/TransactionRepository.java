package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
