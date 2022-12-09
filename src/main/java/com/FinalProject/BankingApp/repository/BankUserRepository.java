package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelActors.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankUserRepository extends JpaRepository<BankUser,Long> {

    Optional<BankUser> findByUsername(String username);
}
