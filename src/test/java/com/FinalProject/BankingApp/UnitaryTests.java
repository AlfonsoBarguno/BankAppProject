package com.FinalProject.BankingApp;

import com.FinalProject.BankingApp.model.modelAccounts.CheckingAccount;
import com.FinalProject.BankingApp.model.modelAccounts.CreditCardAccount;
import com.FinalProject.BankingApp.model.modelAccounts.SavingsAccount;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UnitaryTests {


    @BeforeEach
    void setUp() {

        CheckingAccount checkingAccount = new CheckingAccount(BigDecimal.valueOf(3000),
                Status.ACTIVE, LocalDate.of(2000, 3, 3), "secretKey",
                new AccountHolder(), new AccountHolder(), new ArrayList<>(), new ArrayList<>(),
                BigDecimal.valueOf(100));

        CreditCardAccount creditCardAccount = new CreditCardAccount(
                BigDecimal.valueOf(0.2), BigDecimal.valueOf(1000000000));
    }

    @Test
    void should_Set_MinimunBalance_Of_250() {

        CheckingAccount checkingAccount = new CheckingAccount(BigDecimal.valueOf(3000),
                Status.ACTIVE, LocalDate.of(2000, 3, 3), "secretKey",
                new AccountHolder(), new AccountHolder(), new ArrayList<>(), new ArrayList<>(),
                BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(250), checkingAccount.getBalance());

    }

    @Test
    void should_Apply_PenaltyFee_When_Balance_Is_Below_MinimumBalance() {

        CheckingAccount checkingAccount = new CheckingAccount(BigDecimal.valueOf(100),
                Status.ACTIVE, LocalDate.of(2000, 3, 3), "secretKey",
                new AccountHolder(), new AccountHolder(), new ArrayList<>(), new ArrayList<>(),
                BigDecimal.valueOf(100));

        assertEquals(BigDecimal.valueOf(60), checkingAccount.getBalance());

    }

    @Test
    void should_Limit_Credit_Over_1000000() {

        CreditCardAccount creditCardAccount = new CreditCardAccount(
                BigDecimal.valueOf(0.2), BigDecimal.valueOf(1000000000));

        assertEquals(BigDecimal.valueOf(1000000), creditCardAccount.getCreditLimit());

    }

    @Test
    void should_Have_A_Default_Credit_Limit_Of_100() {

        CreditCardAccount creditCardAccount = new CreditCardAccount(
                BigDecimal.valueOf(0.2), BigDecimal.valueOf(0));

        assertEquals(BigDecimal.valueOf(100), creditCardAccount.getCreditLimit());

    }

    @Test
    void should_Have_A_Default_InterestRate_Of_00025() {

        SavingsAccount savingsAccount = new SavingsAccount
                (BigDecimal.valueOf(250), BigDecimal.valueOf(0));

        assertEquals(BigDecimal.valueOf(0.0025), savingsAccount.getInterestRate());


    }

    @Test
    void should_Apply_Interest_Rate() {


    }

    //Transaction Test

    //Substract Test

    //Add Test
}
