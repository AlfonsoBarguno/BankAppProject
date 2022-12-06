package com.FinalProject.BankingApp.model.modelAccounts;

import com.FinalProject.BankingApp.model.modelActors.AccountHolder;
import com.FinalProject.BankingApp.model.modelActors.Status;
import com.FinalProject.BankingApp.model.modelTransaction.Transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
public class CreditCardAccount extends Account {


    private BigDecimal interestRate = BigDecimal.valueOf((long) 0.2);
    //por defecto, 0.2; puede ser menor que 0.2 pero no menor que 0.1;
    // se carga al balance cada mes.
    @Max(value=1000000)
    private BigDecimal creditLimit= BigDecimal.valueOf(100);
    //por defecto, 100. Puede ser mayor que 100 pero menor que 1000000


    public CreditCardAccount(BigDecimal interestRate, BigDecimal creditLimit) {
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }

    public CreditCardAccount(BigDecimal balance, Status status, LocalDate creationDate, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, List<Transaction> sendingTransactionList, List<Transaction> receivingTransactionList, BigDecimal interestRate, BigDecimal creditLimit) {
        super(balance, status, creationDate, secretKey, primaryOwner, secondaryOwner, sendingTransactionList, receivingTransactionList);
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {

        this.interestRate = interestRate;

        if(interestRate.doubleValue()<0.1){

            this.interestRate = BigDecimal.valueOf((long)0.1);
        }
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }
}
