package com.FinalProject.BankingApp.model.modelAccounts;

import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@PrimaryKeyJoinColumn(name="id")
@Entity
@Data
@NoArgsConstructor
public class CheckingAccount extends Account {

    private final BigDecimal monthlyMaintenanceFee = BigDecimal.valueOf(12); //12 al mes


    private BigDecimal minimumBalance = BigDecimal.valueOf(250); //min=250; si se baja, balance=balance-penaltyFee
    //final


    public CheckingAccount(BigDecimal balance, Status status, LocalDate creationDate, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, List<Transaction> sendingTransactionList, List<Transaction> receivingTransactionList, BigDecimal minimumBalance) {
        super(balance, status, secretKey, primaryOwner, secondaryOwner, sendingTransactionList, receivingTransactionList);
        setMinimumBalance(minimumBalance);
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }




    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {

        this.minimumBalance = minimumBalance;

        if(minimumBalance.intValue()<250){

            this.minimumBalance= BigDecimal.valueOf(250);

            System.out.println("The minimum balance is 250.");

        }
    }

    //método para aplicar la penaltyFee.
    // Este método debe estar presente en substract y en transaction
    public void applyPenaltyFee(){

        if(getBalance().intValue()<minimumBalance.intValue()){

            setBalance(getBalance().subtract(getPenaltyFee()));
        }
    }




}
