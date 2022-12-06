package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
