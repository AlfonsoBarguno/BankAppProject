package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<CheckingAccount,Long> {
}
