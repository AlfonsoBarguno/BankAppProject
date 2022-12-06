package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsRepository extends JpaRepository<SavingsAccount, Long> {
}
