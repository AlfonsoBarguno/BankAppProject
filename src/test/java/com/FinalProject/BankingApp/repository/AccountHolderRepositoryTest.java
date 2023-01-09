package com.FinalProject.BankingApp.repository;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AccountHolderRepositoryTest {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Test
    void shouldFindByUsername(){

        //given
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setUsername("marlo");
        accountHolderRepository.save(accountHolder);

        //when
        Optional<AccountHolder> expected = accountHolderRepository.findByUsername("marlo");

        //then
        assertEquals(expected,accountHolder);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}