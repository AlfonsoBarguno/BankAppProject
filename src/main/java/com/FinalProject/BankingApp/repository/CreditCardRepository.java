package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardAccount, Long> {
}
