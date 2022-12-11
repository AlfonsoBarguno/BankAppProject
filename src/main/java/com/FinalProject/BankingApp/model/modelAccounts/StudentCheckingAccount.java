package com.FinalProject.BankingApp.model.modelAccounts;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Status;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class StudentCheckingAccount extends Account {

    private String secretKey;

    public StudentCheckingAccount(BigDecimal balance, Status status, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, List<Transaction> sendingTransactionList, List<Transaction> receivingTransactionList, BigDecimal minimumBalance, BigDecimal interestRate) {
    }


//es igual que Account


}
