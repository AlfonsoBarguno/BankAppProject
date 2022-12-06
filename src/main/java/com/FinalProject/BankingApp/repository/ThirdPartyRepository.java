package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelActors.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty,Long> {
}
