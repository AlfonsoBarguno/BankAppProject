package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long> {
}
