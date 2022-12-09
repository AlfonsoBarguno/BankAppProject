package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelSecurity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
